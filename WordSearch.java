class Solution {
    public boolean exist(char[][] board, String word) {
          int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existHelper(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
     private boolean existHelper(char[][] board, int i, int j, String word, int index) {
        if (index == word.length())
            return true;
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;
        
        char temp = board[i][j];
        board[i][j] = ' '; // Mark cell as visited
        
        boolean found = existHelper(board, i + 1, j, word, index + 1) ||
                        existHelper(board, i - 1, j, word, index + 1) ||
                        existHelper(board, i, j + 1, word, index + 1) ||
                        existHelper(board, i, j - 1, word, index + 1);
        
        board[i][j] = temp; // Reset cell
        
        return found;
    }
}