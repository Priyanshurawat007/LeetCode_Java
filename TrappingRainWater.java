package LeetCode;
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0; // No water can be trapped with less than 3 bars
        
        int left = 0, right = n - 1;
        int left_max = 0, right_max = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    water += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    water += right_max - height[right];
                }
                right--;
            }
        }
        
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Example test cases
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height1)); // Output: 6

        int[] height2 = {4,2,0,3,2,5};
        System.out.println(solution.trap(height2)); // Output: 9
    }
}
