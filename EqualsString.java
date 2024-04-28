public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Join all strings in word1 to form a single string
        String str1 = String.join("", word1);
        
        // Join all strings in word2 to form a single string
        String str2 = String.join("", word2);
        
        // Compare the two resulting strings
        return str1.equals(str2);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        boolean result = solution.arrayStringsAreEqual(word1, word2);
        
        System.out.println("Output: " + result); // Expected output: true
    }
}
