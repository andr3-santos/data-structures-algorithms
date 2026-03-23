import java.util.*;

// ═══════════════════════════════════════
//  GRAPH SETUP (Adjacency List)
// ═══════════════════════════════════════
class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // remove this line for directed graph
    }

    public List<Integer> getNeighbors(int node) {
        return adjList.get(node);
    }


    // ═══════════════════════════════════════
    //  BFS — Queue based, level by level
    // ═══════════════════════════════════════
    public Set<Integer> bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (visited.contains(node)) {
                continue;
            }

            for (int neighbour: getNeighbors(node)) {
                queue.offer(neighbour);
                visited.add(node);
            }
        }

        return visited;
    }


    // ═══════════════════════════════════════
    //  DFS — Recursive
    // ═══════════════════════════════════════
    public Set<Integer> dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);

        return visited;
    }

    private void dfsHelper(int node, Set<Integer> visited) {
       for (int child : getNeighbors(node)) {
           if (visited.contains(child)) {
               continue;
           }
           visited.add(child);
           dfsHelper(child, visited);
       }
    }


    // ═══════════════════════════════════════
    //  DFS — Iterative (Stack based)
    // ═══════════════════════════════════════
    public void dfsIterative(int start) {
    }

    // ═══════════════════════════════════════
//  MAIN — Wire it up and test
// ═══════════════════════════════════════
    public static class Main {
        public static void main(String[] args) {
            Graph g = new Graph(6);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 3);
            g.addEdge(1, 4);
            g.addEdge(2, 5);

            //   0
            //  / \
            // 1   2
            // |\ \
            // 3 4  5

            System.out.printf("BFS: %s\n", g.bfs(0));
            System.out.printf("DFS recursive: %s\n", g.dfs(0));
            g.dfs(0);
            System.out.println();
            System.out.print("DFS iterative: ");
            g.dfsIterative(0);
            System.out.println();
        }
    }

}