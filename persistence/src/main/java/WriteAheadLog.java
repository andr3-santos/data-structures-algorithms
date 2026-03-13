import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

/**
 * NOT thread-safe. Callers are responsible for external synchronization.
 * KeyValueStoreLocks ReadWriteLock guarantees that append() is never called concurrently.
 */
public class WriteAheadLog implements Closeable {
    private static final byte START_MARKER = (byte) 0xAA;
    private static final byte END_MARKER = (byte) 0xFF;
    private static final byte OP_PUT = 0x01;
    private static final byte OP_DELETE = 0x02;

    private final Path logFile;
    private long sequenceNumber = 0;
    private final DataOutputStream out;

    public WriteAheadLog(Path logFile) throws IOException {
        this.out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(logFile.toFile(), true)));
        this.logFile = logFile;
    }

    public void append(String operation, String key, String value) throws IOException {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        byte[] valueBytes = Optional.ofNullable(value)
                .map(v -> v.getBytes(StandardCharsets.UTF_8))
                .orElseGet(() -> new byte[0]);

        out.writeByte(START_MARKER);
        out.writeLong(sequenceNumber++);
        out.writeByte(operation.equals("PUT") ? OP_PUT : OP_DELETE);
        out.writeInt(keyBytes.length);
        out.write(keyBytes);
        out.writeInt(valueBytes.length);
        out.write(valueBytes);
        out.writeByte(END_MARKER);
        out.flush();
    }

    public void replay(KeyValueStoreLocks store) throws IOException {
        if (!Files.exists(logFile)) return;

        try (DataInputStream in = new DataInputStream(new FileInputStream(logFile.toFile()))) {
            long prevSeqNr = 0L;
            while (in.available() > 0) {
                byte startMarker = in.readByte();
                if (startMarker != START_MARKER) {
                    // corrupt log, stop replaying
                    break;
                }

                long seqNr = in.readLong();
                byte operation = in.readByte();

                int keyLength = in.readInt();
                String key = new String(in.readNBytes(keyLength), StandardCharsets.UTF_8);

                int valueLength = in.readInt();
                String value = new String(in.readNBytes(valueLength), StandardCharsets.UTF_8);

                byte endMarker = in.readByte();

                if (endMarker != END_MARKER) {
                    // corrupt log, stop replaying
                    break;
                }

                if (prevSeqNr > seqNr) {
                    // we messed up the sequencing and stuff is out of order
                    break;
                }
                prevSeqNr = seqNr;

                switch (operation) {
                    case OP_PUT -> store.put(key, value);
                    case OP_DELETE -> store.delete(key);
                    default -> System.out.println("Unexpected operation"); // need to properly handle this
                }

            }
        }
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
