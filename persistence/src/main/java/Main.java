import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path dbDir = Path.of("mydb");

//        // --- RUN 1: write some data ---
//        System.out.println("=== First run: writing data ===");
//        try (KeyValueStoreLocks db = KeyValueStoreLocks.open(dbDir)) {
//            db.put("user:1", "Alice");
//            db.put("user:2", "Bob");
//            db.put("user:3", "Charlie");
//            db.delete("user:2");
//            System.out.println("Written 3 keys, deleted 1");
//            System.out.println("Size before restart: " + db.size()); // expect 2
//        }

        // --- RUN 2: reopen and verify ---
        System.out.println("\n=== Second run: verifying recovery ===");
        try (KeyValueStoreLocks db = KeyValueStoreLocks.open(dbDir)) {
            System.out.println("Size after restart: " + db.size()); // expect 2
            System.out.println("user:1 → " + db.get("user:1")); // expect Alice
            System.out.println("user:2 → " + db.get("user:2")); // expect empty
            System.out.println("user:3 → " + db.get("user:3")); // expect Charlie
        }
    }
}