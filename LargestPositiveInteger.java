import java.util.*;

public class Solution {
    public static int largestPositiveWithNegative(int[] nums) {
        // Use a set to store all elements in nums for quick lookup
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        
        // Initialize the maximum valid k found
        int max_k = -1;
        
        // Iterate through nums to find the largest valid k
        for (int num : nums) {
            if (num > 0 && num_set.contains(-num)) {
                max_k = Math.max(max_k, num);
            }
        }
        
        return max_k;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {-1, 2, -3, 3};
        int[] nums2 = {-1, 10, 6, 7, -7, 1};
        int[] nums3 = {-10, 8, 6, 7, -2, -3};

        System.out.println(largestPositiveWithNegative(nums1)); // Output: 3
        System.out.println(largestPositiveWithNegative(nums2)); // Output: 7
        System.out.println(largestPositiveWithNegative(nums3)); // Output: -1
    }
}
