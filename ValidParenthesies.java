class ValidParenthesies{
    public boolean checkValidString(String s) {
    Deque<Integer> leftParenthesesStack = new ArrayDeque<>();
        Deque<Integer> asterisksStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftParenthesesStack.push(i);
            } else if (ch == '*') {
                asterisksStack.push(i);
            } else { // ch == ')'
                if (!leftParenthesesStack.isEmpty()) {
                    leftParenthesesStack.pop();
                } else if (!asterisksStack.isEmpty()) {
                    asterisksStack.pop();
                } else {
                    return false; // No matching left parenthesis or asterisk found
                }
            }
        }

        while (!leftParenthesesStack.isEmpty()) {
            if (asterisksStack.isEmpty() || leftParenthesesStack.peek() > asterisksStack.peek()) {
                return false; // No matching asterisk found for the remaining left parentheses
            }
            leftParenthesesStack.pop();
            asterisksStack.pop();
        }

        return true;
    }
}