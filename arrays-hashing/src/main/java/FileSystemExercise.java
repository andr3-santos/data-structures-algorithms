import java.util.*;

public class FileSystemExercise {

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.mkdir("/a/b/c");
        List<String> dirPrint = fs.ls("/a/b");
        System.out.println(dirPrint);
    }

    public static class FileSystem {
        Node baseNode = new Node("/");

        public void mkdir(String path) {
            Node head = baseNode;
            String[] dirs = path.split("/");
            for (String dir : dirs) {
                Node n = new Node(dir);
                head.childNodes.add(n);
                head = n;
            }
        }

        public void addContentToFile(String fileName, String data) {

        }

        public String readContentFromFile(String filePath) {
            return "";
        }

        public List<String> ls(String path) {
            String[] dirs = path.split("/");
            Queue<String> dirQueue = new LinkedList<>(Arrays.asList(dirs));

            Node curr = baseNode;
            List<String> directoriesList = new ArrayList<>();
            while (!dirQueue.isEmpty()) {
                String dirPath = dirQueue.peek();

                for (Node child : curr.childNodes) {
                    if (child.path.equals(dirPath)) {
                        curr = child;
                        dirQueue.remove();
                    }
                }
            }

            curr.childNodes.stream()
                    .map(n -> n.path)
                    .forEach(directoriesList::add);

            return directoriesList;
        }
    }

    public static class Node {
        String path;
        Set<Node> childNodes;

        public Node(String path) {
            this.path = path;
            this.childNodes = new HashSet<>();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return Objects.equals(this.path, node.path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(path);
        }
    }
}
