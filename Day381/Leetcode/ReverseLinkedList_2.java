//Leetcode
//206. Reverse Linked List - Recursive method
//Time complexity: O(N). We move to the end of the list and achieve our reversed list. Thus, 
//the time complexity is O(N) where N represents the number of nodes.
//Space complexity: O(1). Apart from recursion using stack space, no external storage is used. Thus, space complexity is O(1).

package Leetcode;

public class ReverseLinkedList_2 {

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
        return reverseListHelper(head, null);
    }

    public static ListNode reverseListHelper(ListNode head, ListNode newHead) {
        // base case
        if (head == null)
            return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return reverseListHelper(next, head);
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
