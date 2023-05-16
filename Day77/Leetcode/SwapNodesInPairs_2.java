//Leetcode - recursive solution
//24. Swap Nodes in Pairs
//Time complexity: O(N)
//Space complexity: O(N/2)

package Leetcode;

public class SwapNodesInPairs_2 {
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = swapPairs(head);
        printNodes(newHead);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode nex = null;
        ListNode prev = null;

        int count = 0;
        while (curr != null && count < 2) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
            count++;
        }

        if (nex != null) {
            head.next = swapPairs(nex);
        }
        return prev;
    }

    public static void printNodes(ListNode newHead) {
        while (newHead != null) {
            System.out.print(newHead.val);
            newHead = newHead.next;
        }
    }
}
