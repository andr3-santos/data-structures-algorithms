import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore {

    private final Map<String, String> store = new ConcurrentHashMap<>();

    // return boolean here so that clients know if the value existed before or not.
    public boolean putIfAbsent(String key, String value) {
        return store.putIfAbsent(key, value) == null;
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(store.get(key));
    }

    public void delete(String key) {
        store.remove(key);
    }

    public int size() {
        return store.size();
    }
}
