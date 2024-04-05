public class StrGood {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && Math.abs(sb.charAt(sb.length() - 1) - c) == 32) {
                sb.deleteCharAt(sb.length() - 1); // Remove the last character
            } else {
                sb.append(c); // Otherwise, add the character to the result
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        StrGood solution = new StrGood();
        String s = "leEeetcode";
        System.out.println(solution.makeGood(s)); // Output: "leetcode"
    }
}
