// Write a java program, given the pair of vertex associated to the edges of an undirected graph,
// it will output the degree of vertex.

import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Handle the case of an empty graph
        if (numVertices == 0 && numEdges == 0) {
            System.out.println("\nVertex Degrees: Everything is ZERO = 0");
            return;
        }

        System.out.println("\nEnter as: \"Initial_Vertex End_Vertex\"");
        // Initialize a map to store the degree of each vertex
        Map<Integer, Integer> degreeMap = new HashMap<>();

        // Read the edges and calculate the degree of each vertex
        for (int i = 0; i < numEdges; i++) {
            System.out.print("Edge "+(i+1)+": ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            // Update the degree of vertex u
            degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);

            // Update the degree of vertex v
            degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
        }

        // Display the degree of each vertex
        System.out.println("\nVertex Degrees:");
        for (int vertex = 1; vertex <= numVertices; vertex++) {
            int degree = degreeMap.getOrDefault(vertex, 0);
            System.out.println("Vertex " + vertex + ": " + degree);
        }
    }
}