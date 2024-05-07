class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode doubleLinkedList(ListNode head) {
        // Step 1: Convert linked list to number
        int num = 0;
        ListNode current = head;
        while (current != null) {
            num = num * 10 + current.val;
            current = current.next;
        }
        
        // Step 2: Double the number
        int doubledNum = num * 2;
        
        // Step 3: Convert number back to linked list
        ListNode dummyHead = new ListNode(0);
        
        // Handle case where doubledNum is 0
        if (doubledNum == 0) {
            return new ListNode(0);
        }
        
        // Extract digits from doubledNum and create new nodes
        while (doubledNum > 0) {
            int digit = doubledNum % 10;
            ListNode newNode = new ListNode(digit);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            doubledNum /= 10;
        }
        
        return dummyHead.next;
    }
    
    // Helper function to print linked list for testing
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1: [1,8,9] -> 189 -> 378 -> [3,7,8]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(9);
        ListNode doubledHead1 = solution.doubleLinkedList(head1);
        solution.printLinkedList(doubledHead1);
        
        // Example 2: [9,9,9] -> 999 -> 1998 -> [1,9,9,8]
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        ListNode doubledHead2 = solution.doubleLinkedList(head2);
        solution.printLinkedList(doubledHead2);
    }
}
