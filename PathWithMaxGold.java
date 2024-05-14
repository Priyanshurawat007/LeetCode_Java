class Solution {
    private int maxGold;

    public int getMaximumGold(int[][] grid) {
        maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell contains gold, start DFS from this cell
                if (grid[i][j] > 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return maxGold;
    }

    private void dfs(int[][] grid, int row, int col, int currentGold) {
        // Check for out-of-bounds or empty cell
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }

        // Add the gold in the current cell to the current total
        currentGold += grid[row][col];
        // Update the maximum gold collected
        maxGold = Math.max(maxGold, currentGold);

        // Save the gold amount in the current cell and mark it as visited by setting it to 0
        int temp = grid[row][col];
        grid[row][col] = 0;

        // Explore all 4 possible directions (up, down, left, right)
        dfs(grid, row - 1, col, currentGold);
        dfs(grid, row + 1, col, currentGold);
        dfs(grid, row, col - 1, currentGold);
        dfs(grid, row, col + 1, currentGold);

        // Restore the gold amount in the current cell
        grid[row][col] = temp;
    }
}
