//Leetcode
//2487. Remove Nodes From Linked List - Futher Optimising Code - Filter and Reversal at same time
//Time complexity: O(n), 2 pass
//Space complexity: O(1)

package Leetcode;

public class RemoveNodesFromLinkedList_4 {

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
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = null;
        ListNode res = removeNodes(head);
        printList(res);
    }

    public static ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = prev.next;
        prev.next = null;
        while (curr != null) {
            ListNode temp = curr.next;
            if (curr.val >= prev.val) {
                curr.next = prev;
                prev = curr;
            }
            curr = temp;
        }

        return prev;
    }

    static void printList(ListNode head) {
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
