// Write a java program that receives a list of edges of a simple graph
// and determine whether the graph is bipartite.

import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Initialize adjacency list for the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= numVertices; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Read the edges of the graph
        System.out.println("Enter the edges (vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // For undirected graph
        }

        // Initialize colors for vertices
        int[] colors = new int[numVertices + 1];

        // Check if the graph is bipartite
        if (isBipartite(graph, colors)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }

    // Helper function to check if the graph is bipartite
    private static boolean isBipartite(Map<Integer, List<Integer>> graph, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == 0) {
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v : graph.get(u)) {
                        if (colors[v] == 0) {
                            colors[v] = -colors[u];
                            queue.offer(v);
                        } else if (colors[v] == colors[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
