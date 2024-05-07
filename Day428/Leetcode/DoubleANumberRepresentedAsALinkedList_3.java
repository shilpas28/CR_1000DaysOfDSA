//Leetcode
//2816. Double a Number Represented as a Linked List - Recursion
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class DoubleANumberRepresentedAsALinkedList_3 {

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
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);
        head.next.next.next = null;
        ListNode res = doubleIt(head);
        printList(res);
    }

    public static ListNode doubleIt(ListNode head) {
        int carry = twiceOfVal(head);
        // If there's a carry, insert a new node at the beginning with the carry value
        if (carry != 0) {
            head = new ListNode(carry, head);
        }
        return head;
    }

    // To compute twice the value of each node's value and propagate carry
    public static int twiceOfVal(ListNode head) {
        // Base case: if head is null, return 0
        if (head == null)
            return 0;
        // Double the value of current node and add the result of next nodes
        int doubledValue = head.val * 2 + twiceOfVal(head.next);
        // Update current node's value with the units digit of the result
        head.val = doubledValue % 10;
        // Return the carry (tens digit of the result)
        return doubledValue / 10;
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
