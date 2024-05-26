import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Initialize the incidence matrix
        int[][] incidenceMatrix = new int[numVertices + 1][numEdges + 1];

        // Read the edges and their counts, and construct the incidence matrix
        System.out.println("Enter the edges and their counts (format: vertex1 vertex2 count):");
        for (int i = 1; i <= numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int count = scanner.nextInt();
            incidenceMatrix[u][i] = count;
            incidenceMatrix[v][i] = count;
        }

        // Display the incidence matrix
        System.out.println("\nIncidence Matrix:");
        for (int i = 1; i <= numVertices; i++) {
            for (int j = 1; j <= numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}