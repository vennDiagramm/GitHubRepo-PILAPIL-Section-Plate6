// isomorphic or not

import java.util.*;

public class Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Details for Graph 1");
        System.out.print("Enter the number of vertices in graph 1: ");
        int numVertices1 = scanner.nextInt();
        System.out.print("Enter the number of edges in graph 1: ");
        int numEdges1 = scanner.nextInt();

        System.out.println("\nEnter Details for Graph 2");
        System.out.print("Enter the number of vertices in graph 2: ");
        int numVertices2 = scanner.nextInt();
        System.out.print("Enter the number of edges in graph 2: ");
        int numEdges2 = scanner.nextInt();

        // Quick check: if number of vertices or edges is different, graphs cannot be isomorphic
        if (numVertices1 != numVertices2 || numEdges1 != numEdges2) {
            System.out.println("The graphs are not isomorphic.");
            return;
        }

        System.out.println("\nEnter the edges of graph 1 (format: vertex1 vertex2):");
        Set<String> edges1 = new HashSet<>();
        for (int i = 0; i < numEdges1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges1.add(u + " " + v);
            edges1.add(v + " " + u); // For undirected graph, add both directions
        }

        System.out.println("Enter the edges of graph 2 (format: vertex1 vertex2):");
        Set<String> edges2 = new HashSet<>();
        for (int i = 0; i < numEdges2; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges2.add(u + " " + v);
            edges2.add(v + " " + u); // For undirected graph, add both directions
        }

        if (edges1.equals(edges2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }
}