//Leetcode
//2816. Double a Number Represented as a Linked List - Two Pointers 
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class DoubleANumberRepresentedAsALinkedList_4 {

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
        ListNode curr = head;
        ListNode prev = null;
        // Traverse the linked list
        while (curr != null) {
            int twiceOfVal = curr.val * 2;

            // If the doubled value is less than 10
            if (twiceOfVal < 10) {
                curr.val = twiceOfVal;
            }
            // If doubled value is 10 or greater
            else if (prev != null) { // other than first node
                // Update current node's value with units digit of the doubled value
                curr.val = twiceOfVal % 10;
                // Add the carry to the previous node's value
                prev.val = prev.val + 1;
            }
            // If it's the first node and doubled value is 10 or greater
            else { // first node
                   // Create a new node with carry as value and link it to the current node
                head = new ListNode(1, curr);
                // Update current node's value with units digit of the doubled value
                curr.val = twiceOfVal % 10;
            }
            // Update prev and curr pointers
            prev = curr;
            curr = curr.next;
        }
        return head;
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
