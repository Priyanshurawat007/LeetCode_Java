import java.util.*;

public class Solution {
    // Memoization map to store computed results
    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        return dfs(ring, key, 0, 0);
    }

    private int dfs(String ring, String key, int idx, int pos) {
        // Base case: All characters in key are spelled
        if (idx == key.length()) {
            return 0;
        }

        // Check if the result is already computed
        if (memo.containsKey(idx) && memo.get(idx).containsKey(pos)) {
            return memo.get(idx).get(pos);
        }

        int minSteps = Integer.MAX_VALUE;

        // Iterate over the ring to find matching characters
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(idx)) {
                // Calculate steps to align ring[i] at position 'pos'
                int clockSteps = (i - pos + ring.length()) % ring.length();
                int counterclockSteps = (pos - i + ring.length()) % ring.length();

                // Calculate total steps for this alignment and recurse
                int steps = Math.min(clockSteps, counterclockSteps) + 1;
                steps += dfs(ring, key, idx + 1, i);

                // Update minimum steps
                minSteps = Math.min(minSteps, steps);
            }
        }

        // Memoize the result
        memo.computeIfAbsent(idx, k -> new HashMap<>()).put(pos, minSteps);

        return minSteps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ring = "godding";
        String key = "gd";
        int minSteps = solution.findRotateSteps(ring, key);
        System.out.println("Minimum steps to spell all characters: " + minSteps);
    }
}
