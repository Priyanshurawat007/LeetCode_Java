import java.util.*;

public class Solution {

    public static int[] sweetsAndAnts(int T, int N, int[] S) {
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            if (i > 0)
                S[i] += S[i - 1]; // Calculate cumulative freshness value
            int threshold = N - S[i]; // Freshness value threshold for ants
            if (threshold < 0) // If threshold is negative, no sweets will be stolen
                threshold = 0;
            result[i] = threshold > 0 ? 1 : 0; // If threshold is greater than 0, sweet is stolen
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Number of sweets
            int[] S = new int[N];
            for (int i = 0; i < N; i++) {
                S[i] = scanner.nextInt(); // Freshness values of sweets
            }
            int[] result = sweetsAndAnts(T, N, S);
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " "); // Print the result array
            }
            System.out.println(); // Move to the next line for the next test case
        }
        scanner.close();
    }
}
