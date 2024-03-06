//Leetcode
//141. Linked List Cycle - Using extra temp Node method. (This method breaks the original structure of linked list. 
//So not an efficent method)
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

public class LinkedListCycle_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            if (curr.next == null)
                return false;
            if (curr.next == temp)
                return true;
            ListNode curr_next = curr.next;
            curr.next = temp;
            curr = curr_next;
        }
        return false;
    }
}
