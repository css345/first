import java.util.*;

public class SumofSubsetsDemo {
    static boolean solutionFound = false;

    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int w[] = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        sc.close();

        findsubsets(w, target);

        if (!solutionFound) {
            System.out.println("No solution exists");
        }
    }

    public static void findsubsets(int w[], int target) {
        listsubsets(w, 0, 0, target, new ArrayList<>());
    }

    public static void listsubsets(int w[], int item, int sum, int target, List<Integer> subset) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            System.out.println(subset);
            solutionFound = true;
            return;
        }

        if (item >= w.length) {
            return;
        }

        subset.add(w[item]);
        listsubsets(w, item + 1, sum + w[item], target, subset);

        subset.remove(subset.size() - 1);
        listsubsets(w, item + 1, sum, target, subset);
    }
}