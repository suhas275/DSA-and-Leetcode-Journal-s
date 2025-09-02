// Floyd’s Cycle Detection (Tortoise & Hare) → O(1) space

// This is the optimal approach interviewers expect.

// Idea:

// Use two pointers:

// slow moves 1 step at a time.

// fast moves 2 steps at a time.

// If there’s a cycle, they will eventually meet.

// If fast or fast.next becomes null, then no cycle exists.

package Blink_75.Linked_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move 1 step
            fast = fast.next.next;   // move 2 steps

            if (slow == fast) return true; // cycle detected
        }

        return false; // reached end, no cycle
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        // Example 1: [3,2,0,-4], pos = 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // create cycle at pos = 1

        Solution sol = new Solution();
        System.out.println("Example 1: " + sol.hasCycle(head1)); // true

        // Example 2: [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // cycle at pos = 0

        System.out.println("Example 2: " + sol.hasCycle(head2)); // true

        // Example 3: [1], pos = -1
        ListNode head3 = new ListNode(1);

        System.out.println("Example 3: " + sol.hasCycle(head3)); // false
    }
}
