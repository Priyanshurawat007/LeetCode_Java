import java.util.*;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        // Map to keep track of score indices
        Map<Integer, Integer> scoreIndexMap = new HashMap<>();
        
        // Populate the map with score indices
        for (int i = 0; i < score.length; i++) {
            scoreIndexMap.put(score[i], i);
        }
        
        // Sort scores in descending order
        Arrays.sort(score);
        String[] ranks = new String[score.length];
        
        // Assign ranks based on the sorted scores
        for (int i = score.length - 1; i >= 0; i--) {
            int originalIndex = scoreIndexMap.get(score[i]);
            if (i == score.length - 1) {
                ranks[originalIndex] = "Gold Medal";
            } else if (i == score.length - 2) {
                ranks[originalIndex] = "Silver Medal";
            } else if (i == score.length - 3) {
                ranks[originalIndex] = "Bronze Medal";
            } else {
                ranks[originalIndex] = String.valueOf(score.length - i);
            }
        }
        
        return ranks;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] score1 = {5, 4, 3, 2, 1};
        String[] result1 = solution.findRelativeRanks(score1);
        System.out.println(Arrays.toString(result1)); 
        // Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
        
        int[] score2 = {10, 3, 8, 9, 4};
        String[] result2 = solution.findRelativeRanks(score2);
        System.out.println(Arrays.toString(result2)); 
        // Output: ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
    }
}
