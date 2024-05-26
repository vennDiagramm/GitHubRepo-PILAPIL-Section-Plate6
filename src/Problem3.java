// Write a java program that will determine if a graph has a cycle or not.

import java.util.*;

public class Problem3 {
    private static boolean hasCycle = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Initialize the adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Input adjacency list
        System.out.println("Enter the neighbors of each vertex (use \" -1\" to proceed.)");
        for (int i = 1; i <= n; i++) {
            System.out.print("Vertex " + i + " neighbors: ");
            List<Integer> neighbors = new ArrayList<>();
            while (true) {
                int neighbor = scanner.nextInt();
                if (neighbor == -1) break;
                neighbors.add(neighbor);
            }
            graph.put(i, neighbors);
        }

        // Perform DFS to detect cycles
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();
        for (int vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(graph, vertex, visited, recStack);
                if (hasCycle) {
                    break;
                }
            }
        }

        // Display the result
        if (hasCycle && visited.size() == n) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int vertex, Set<Integer> visited, Set<Integer> recStack) {
        visited.add(vertex);
        recStack.add(vertex);

        for (int neighbor : graph.getOrDefault(vertex, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, recStack);
            } else if (recStack.contains(neighbor)) {
                hasCycle = true;
                return;
            }
        }

        recStack.remove(vertex);
    }
}