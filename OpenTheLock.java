import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendsSet.add(deadend);
        }
        
        if (deadendsSet.contains("0000")) {
            return -1;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return moves;
                }
                for (int j = 0; j < 4; j++) {
                    char[] chars = current.toCharArray();
                    char c = chars[j];
                    chars[j] = c == '9' ? '0' : (char)(c + 1);
                    String next1 = new String(chars);
                    chars[j] = c == '0' ? '9' : (char)(c - 1);
                    String next2 = new String(chars);
                    if (!deadendsSet.contains(next1) && !visited.contains(next1)) {
                        queue.offer(next1);
                        visited.add(next1);
                    }
                    if (!deadendsSet.contains(next2) && !visited.contains(next2)) {
                        queue.offer(next2);
                        visited.add(next2);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
