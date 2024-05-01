public class Solution {
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index != -1) {
            // Extract substring from start to the first occurrence of ch (inclusive)
            String prefix = word.substring(0, index + 1);
            // Reverse the extracted substring
            StringBuilder reversedPrefix = new StringBuilder(prefix).reverse();
            // Append the remaining part of the word after ch to the reversed prefix
            return reversedPrefix.append(word.substring(index + 1)).toString();
        }
        return word; // If ch is not found, return the original word
    }

    public static void main(String[] args) {
        // Test cases
        String word1 = "abcdefd";
        char ch1 = 'd';
        System.out.println(reversePrefix(word1, ch1)); // Output: "dcbaefd"

        String word2 = "abcde";
        char ch2 = 'f';
        System.out.println(reversePrefix(word2, ch2)); // Output: "abcde" (no change)

        String word3 = "ababab";
        char ch3 = 'a';
        System.out.println(reversePrefix(word3, ch3)); // Output: "baabab"
    }
}
