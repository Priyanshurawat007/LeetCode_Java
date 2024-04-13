package LeetCode;

import java.util.Arrays;
import java.util.Stack;

class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return 0;
       }
       
       int rows = matrix.length;
       int cols = matrix[0].length;
       int[] heights = new int[cols]; // Heights array for the histogram
       
       int maxArea = 0;
       
       // Iterate through each row of the matrix
       for (int i = 0; i < rows; i++) {
           // Update heights array for the current row
           for (int j = 0; j < cols; j++) {
               if (matrix[i][j] == '1') {
                   heights[j] += 1;
               } else {
                   heights[j] = 0;
               }
           }
           
           // Calculate the largest rectangle in the current histogram
           maxArea = Math.max(maxArea, largestRectangleArea(heights));
       }
       
       return maxArea;
   }
   
   // Function to calculate the largest rectangle in a histogram
   private int largestRectangleArea(int[] heights) {
       int n = heights.length;
       int maxArea = 0;
       int[] left = new int[n];
       int[] right = new int[n];
       
       Arrays.fill(right, n);
       
       Stack<Integer> stack = new Stack<>();
       for (int i = 0; i < n; i++) {
           while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
               right[stack.peek()] = i;
               stack.pop();
           }
           left[i] = (stack.isEmpty() ? -1 : stack.peek());
           stack.push(i);
       }
       
       for (int i = 0; i < n; i++) {
           maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
       }
       
       return maxArea;
   }
}