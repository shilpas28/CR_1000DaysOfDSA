//Leetcode
//23. Merge k Sorted Lists
//Time complexity: O(NlogK)
//Space complexity: O(K)

package Leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLinkedLists {

    public static class ListNode {
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

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] lists = { head1, head2, head3 };
        ListNode head = mergeKLists(lists);
        System.out.println(head.val);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        // only head pointer of all lists are added
        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while (!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            if (point.next != null) {
                q.add(point.next); // add next of current smallest
            }
        }
        return head.next;
    }

}
