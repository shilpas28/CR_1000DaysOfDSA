//Leetcode
//237. Delete Node in a Linked List - Brute Force solution
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class DeleteNodeInALinkedList {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        printlist(head);
        deleteNode(head.next);
        printlist(head);
    }

    public static void deleteNode(ListNode node) {
        if (node.next == null) {
            return;
        }
        ListNode current = node;
        ListNode prev = null;
        while (current.next != null) {
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }

    public static void printlist(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
