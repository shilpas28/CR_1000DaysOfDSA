//Leetcode
//2487. Remove Nodes From Linked List - Reverse and Filter Approach (Best)
//Time complexity: O(n), where n is the number of nodes in the linked list. 3 pass.
//Space complexity: O(1), as no extra space is used apart from a few pointers.

package Leetcode;

public class RemoveNodesFromLinkedList_3 {

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
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode tempPrev = dummyHead;
        curr = prev;

        while (curr != null) {
            if (curr.val >= tempPrev.val) {
                tempPrev.next = curr;
                tempPrev = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }
        tempPrev.next = null;

        ListNode newPrev = null, newCurr = dummyHead.next;
        while (newCurr != null) {
            ListNode next = newCurr.next;
            newCurr.next = newPrev;
            newPrev = newCurr;
            newCurr = next;
        }

        return newPrev;
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
