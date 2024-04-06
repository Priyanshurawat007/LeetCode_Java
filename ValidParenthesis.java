import java.util.Stack;

public class ValidParenthesis {
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean[] marked = new boolean[s.length()];

        // Find unpaired closing parentheses
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    marked[i] = true;
                }
            }
        }

        // Find unpaired opening parentheses
        while (!stack.isEmpty()) {
            marked[stack.pop()] = true;
        }

        // Construct the valid string
        for (int i = 0; i < s.length(); i++) {
            if (!marked[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s1)); // Output: "lee(t(c)o)de"

        String s2 = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s2)); // Output: "ab(c)d"

        String s3 = "))(((";
        System.out.println(minRemoveToMakeValid(s3)); // Output: ""
    }
}
