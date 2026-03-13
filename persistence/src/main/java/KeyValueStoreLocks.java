import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class KeyValueStoreLocks implements Closeable {

    private final Map<String, String> store = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final WriteAheadLog wal;

    private KeyValueStoreLocks(WriteAheadLog wal) {
        this.wal = wal;
    }

    public static KeyValueStoreLocks open(Path directory) throws IOException {
        Files.createDirectories(directory);
        Path logFile = directory.resolve("wal.log");
        WriteAheadLog wal = new WriteAheadLog(logFile);
        KeyValueStoreLocks store = new KeyValueStoreLocks(wal);
        wal.replay(store);
        return store;
    }

    public void put(String key, String value) throws IOException {
        lock.writeLock().lock();
        try {
            wal.append("PUT", key, value);
            store.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    // return boolean here so that clients know if the value existed before or not.
    public boolean putIfAbsent(String key, String value) throws IOException {
        lock.writeLock().lock();
        try {
            if (store.containsKey(key)) {
                return false;
            }
            wal.append("PUT", key, value);
            store.put(key, value);
            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Optional<String> get(String key) {
        lock.readLock().lock();
        try {
            return Optional.ofNullable(store.get(key));
        } finally {
            lock.readLock().unlock();
        }
    }

    public void delete(String key) throws IOException {
        lock.writeLock().lock();
        try {
            wal.append("DELETE", key, null);
            store.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock();
        try {
            return store.size();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void close() throws IOException {
        wal.close();
    }
}
