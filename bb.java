import java.util.*;

public class Solution {
    public static int minShift(String s1, String s2) {
        // Check whether each character's frequency is equal
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'A']++;
        }
        for (char c : s2.toCharArray()) {
            freq[c - 'A']--;
        }
        for (int f : freq) {
            if (f != 0) {
                return -1;
            }
        }

        // Calculate minimum shifts
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;
        int shifts = 0;
        while (p1 >= 0) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p1--;
                p2--;
            } else {
                p1--;
                shifts++;
            }
        }
        return shifts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        while (t-- > 0) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            int result = minShift(s1, s2);
            System.out.println(result);
        }
    }
}
