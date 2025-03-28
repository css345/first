import java.util.*;
public class NQueensDemo {
	private static int solutionCount = 1;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queens:");
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("Q1");
        } else if (n == 2 || n == 3) {
            System.out.println("No solution exists");
        } else {
            int board[][] = new int[n][n];
            nQueenSolution(board, n, 0);
        }
    }
    public static void nQueenSolution(int board[][], int n, int row) {
       
        if (row >= n) {
            printSolution(board, n);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1; 
                nQueenSolution(board, n, row + 1); 
                board[row][col] = 0; 
            }
        }
    }
    public static boolean isSafe(int board[][], int r, int c, int n) {
     
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 1) {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
    public static void printSolution(int board[][], int n) {
        int count = 1;
		System.out.println("Solution - "+solutionCount++);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q"+(count++)); 
                } else {
                    System.out.print(" 0 "); 
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}