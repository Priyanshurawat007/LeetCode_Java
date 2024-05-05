/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
       if (node == null || node.next == null) {
            return; // Cannot delete if node is null or last node
        }
        
        // Get the value of the next node
        int nextVal = node.next.val;
        
        // Copy the value of the next node to the current node
        node.val = nextVal;
        
        // Update the current node's next pointer to skip the next node
        node.next = node.next.next;
    }
}
