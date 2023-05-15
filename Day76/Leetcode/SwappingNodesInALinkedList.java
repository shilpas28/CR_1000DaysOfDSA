//Leetcode
//1721. Swapping Nodes in a Linked List
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class SwappingNodesInALinkedList {

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
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode newHead = swapNodes(head, k);
        printNodes(newHead);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        int count = 1;

        while (curr != null) {
            if (count < k) {
                pointer1 = pointer1.next;
            }
            if (count > k) {
                pointer2 = pointer2.next;
            }
            curr = curr.next;
            count++;
        }

        int temp = pointer1.val;
        pointer1.val = pointer2.val;
        pointer2.val = temp;

        return head;
    }

    public static void printNodes(ListNode newHead) {
        while (newHead != null) {
            System.out.print(newHead.val);
            newHead = newHead.next;
        }
    }
}
