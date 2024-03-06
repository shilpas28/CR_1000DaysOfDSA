//Leetcode
//141. Linked List Cycle - Using Hash Set method
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

import java.util.HashSet;

public class LinkedListCycle {

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
        HashSet<ListNode> s = new HashSet<ListNode>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (s.contains(curr))
                return true;
            s.add(curr);
        }
        return false;
    }
}
