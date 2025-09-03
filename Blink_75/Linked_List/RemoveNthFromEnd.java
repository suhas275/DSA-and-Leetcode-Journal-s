package Blink_75.Linked_List;

public class RemoveNthFromEnd {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Solution method
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases (like removing head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 1: Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 2: Move both fast & slow until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 3: Remove nth node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Helper to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1: [1,2,3,4,5], n=2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original list: ");
        printList(head);

        head = removeNthFromEnd(head, 2);

        System.out.print("After removing 2nd from end: ");
        printList(head);
    }
}
