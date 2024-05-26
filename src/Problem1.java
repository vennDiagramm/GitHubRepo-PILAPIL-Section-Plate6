// Write a java program that receives a list of edges of a simple graph,
// the program should determine whether it is connected and
// find the number of connected components if it is not connected

import java.util.*;

public class Problem1 {
    // Using adjacency list to represent the graph
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    // The implementation of DFS to check connectivity
    static void DFS(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        for (int neighbor : graph.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                DFS(neighbor, visited);
            }
        }
    }

    // Implementing a counter for connected components
    static int countConnectedComponents() {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                DFS(vertex, visited);
                count++;
            }
        }
        return count;
    }

    // Running the program
    public static void main(String[] args) {

        // Parse input and construct the graph -- This section asks how many vertices & edges
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of vertices
        int m = scanner.nextInt(); // Number of edges

        // User input of (V,E)
        for (int i = 0; i < m; i++) {
            int V = scanner.nextInt();
            int v = scanner.nextInt();
            graph.computeIfAbsent(V, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(V); // Assuming undirected graph
        }

        // Checking connectivity
        Set<Integer> visited = new HashSet<>();
        DFS(1, visited); // Start DFS from any vertex

        // Counting connected components
        int connectedComponents = countConnectedComponents();

        // The display
        if (visited.size() == n) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }
    }
}