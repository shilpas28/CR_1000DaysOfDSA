//Leetcode
//206. Reverse Linked List - Iterative method (best method for intv)
//Time complexity: O(N). Since we are iterating only once through the list and achieving reversed list. 
//Thus, the time complexity is O(N) where N is the number of nodes present in the list.
//Space complexity: O(1). To perform given tasks, no external spaces are used except three-pointers. So, space complexity is O(1).

package Leetcode;

public class ReverseLinkedList {

    static public class ListNode {
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

        ListNode res = reverseList(head);
        printList(res);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
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
