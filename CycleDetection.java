public class Solution {
    public static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected
                return true;
            }
        }

        // No cycle found
        return false;
    }
