// Write a java program that receives the vertex pairs associated to the edges of a graph,
// the program should construct an adjacency matrix for the graph.
// (Produce a version that works when loops, multiple edges, or directed edges are present.)

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Initialize the adjacency matrix
        int[][] adjacencyMatrix = new int[numVertices + 1][numVertices + 1];

        // Read the edges and construct the adjacency matrix
        System.out.println("Enter the edges (format: vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyMatrix[u][v]++; // For directed graph
            adjacencyMatrix[v][u]++; // Comment if directed
        }

        // Display the adjacency matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 1; i <= numVertices; i++) {
            for (int j = 1; j <= numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}