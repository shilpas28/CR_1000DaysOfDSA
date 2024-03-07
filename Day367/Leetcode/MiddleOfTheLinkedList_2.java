//Leetcode - Optimal method (using slow and fast pointers)
//876. Middle of the Linked List
//Time complexity: O(N) 
//Space complexity: O(1)

package Leetcode;

public class MiddleOfTheLinkedList_2 {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(6);
        ListNode middle = middleNode(head);
        System.out.println(middle.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
