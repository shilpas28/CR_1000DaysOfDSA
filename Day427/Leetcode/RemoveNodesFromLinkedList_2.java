//Leetcode
//2487. Remove Nodes From Linked List - Recursive Approach
//Time complexity: O(n), where n is the number of nodes in the linked list.
//Space complexity: O(n), due to the recursive stack space.

package Leetcode;

public class RemoveNodesFromLinkedList_2 {

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
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode nxtGreater = removeNodes(node.next);

        node.next = nxtGreater;
        if (nxtGreater == null || node.val >= nxtGreater.val) {
            return node;
        }
        return nxtGreater;
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
