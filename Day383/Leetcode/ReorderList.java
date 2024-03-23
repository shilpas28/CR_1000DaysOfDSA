//Leetcode
//143. Reorder List
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;

public class ReorderList {

    static class ListNode {
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
        reorderList(head);
        printList(head);
    }

    public static void reorderList(ListNode head) {
        ArrayList<ListNode> dq = new ArrayList<ListNode>();
        ListNode p = head.next;
        while (p != null) {
            dq.add(p);
            p = p.next;
        }
        p = head;
        while (dq.size() > 0) {
            p.next = dq.get(dq.size() - 1);
            p = p.next;
            dq.remove(dq.size() - 1);
            if (dq.size() > 0) {
                p.next = dq.get(0);
                p = p.next;
                dq.remove(0);
            }
        }
        p.next = null;
    }

    public static void printList(ListNode head) {
        ListNode currNode = head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.val + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
