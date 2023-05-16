//Leetcode - iterative solution
//24. Swap Nodes in Pairs
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class SwapNodesInPairs {
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

        if (head == null || head.next == null)
            return head;
        ListNode curr = head.next.next;
        ListNode prev = head;
        head = head.next;
        head.next = prev;
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            ListNode next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
        return head;
    }

    public static void printNodes(ListNode newHead) {
        while (newHead != null) {
            System.out.print(newHead.val);
            newHead = newHead.next;
        }
    }

}
