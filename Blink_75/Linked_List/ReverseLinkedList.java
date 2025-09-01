package Blink_75.Linked_List;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    // Function to reverse a linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // step 1: save next
            curr.next = prev;              // step 2: reverse pointer
            prev = curr;                   // step 3a: move prev
            curr = nextNode;               // step 3b: move curr
        }
        return prev; // new head of reversed list
    }
}

public class ReverseLinkedList {
    // Helper to print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        // Call solution
        Solution sol = new Solution();
        ListNode reversedHead = sol.reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);
    }
}

