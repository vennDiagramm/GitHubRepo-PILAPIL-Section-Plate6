//Write a java program that accepts an adjacency matrix of a graph.
// The program should list the edges of this graph
// and give the number of times each edge appears

import java.util.*;

public class Problem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        // Initialize the adjacency matrix
        int[][] adjacencyMatrix = new int[n][n];

        // Input adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // List of edges and their counts
        Map<String, Integer> edgeCounts = new LinkedHashMap<>();

        // Traverse adjacency matrix to find edges and count their occurrences
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // Note j starts from i + 1 to avoid self-loops and duplicates
                if (adjacencyMatrix[i][j] == 1) {
                    String edge = "(" + (i + 1) + ", " + (j + 1) + ")";
                    edgeCounts.put(edge, edgeCounts.getOrDefault(edge, 0) + 1);
                }
            }
        }

        // Display edges and their counts
        if (edgeCounts.isEmpty()) {
            System.out.println("No edges in the graph.");
        } else {
            System.out.println("\nEdges and their counts:");
            for (Map.Entry<String, Integer> entry : edgeCounts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}