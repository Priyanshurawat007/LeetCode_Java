class Solution {
    public int minFallingPathSum(int[][] grid) {
       int n = grid.length;
        
        // Initialize dp array
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = grid[n - 1][i]; // Base case: last row
        }
        
        // Traverse the matrix from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            // Find the minimum falling path sum for each position in the current row
            for (int j = 0; j < n; j++) {
                int minPathSum = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        minPathSum = Math.min(minPathSum, dp[i + 1][k]);
                    }
                }
                dp[i][j] = grid[i][j] + minPathSum;
            }
        }
        
        // Find the minimum falling path sum in the first row of dp array
        int minFallingPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minFallingPathSum = Math.min(minFallingPathSum, dp[0][j]);
        }
        
        return minFallingPathSum;
    }
}
