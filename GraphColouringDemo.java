import java.util.Scanner;

public class GraphColouringDemo {
    int graph[][];
    int n, m;
    int color[];

    // Constructor to initialize graph, vertices, and colors
    public GraphColouringDemo(int[][] g, int n, int m) {
        this.graph = g;
        this.n = n;
        this.m = m;
        color = new int[n];  // Stores colors assigned to vertices
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices (n): ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter the adjacency matrix (enter 0 or 1): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the number of colors (m): ");
        int m = sc.nextInt();

        GraphColouringDemo gc = new GraphColouringDemo(graph, n, m);

        // Start solving the graph coloring problem
        gc.solveGCP();
    }

    public void solveGCP() {
        if (!solveGC(0)) {
            System.out.println("No solution found!");
            return;
        }
        printSolution();
    }

    public boolean solveGC(int v) {
        if (v == n)  // Base case: If all vertices are assigned a color
            return true;

        // Try assigning each color from 1 to m to vertex v
        for (int i = 1; i <= m; i++) {
            if (isSafe(v, i)) {
                color[v] = i;  // Assign color i to vertex v

                // Recursively solve for the next vertex
                if (solveGC(v + 1))
                    return true;

                // If assigning color i doesn't lead to a solution, backtrack
                color[v] = 0;
            }
        }
        return false;  // If no color can be assigned to vertex v
    }

    public boolean isSafe(int v, int c) {
        // Check adjacency: no adjacent vertices should have the same color
        for (int i = 0; i < n; i++) {
            if (graph[v][i] == 1 && color[i] == c)
                return false;
        }
        return true;
    }

    public void printSolution() {
        System.out.println("The colors assigned are: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + " --> Color " + color[i]);
        }
    }
}