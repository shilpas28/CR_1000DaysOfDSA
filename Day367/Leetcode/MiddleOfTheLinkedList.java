//Leetcode - Naive method
//876. Middle of the Linked List
//Time complexity: O(N) + O(N/2) .We can traverse through the Linked List while maintaining a count of nodes 
//lets say in variable n, and then traversing for 2nd time for n/2 nodes to get to the middle of the list.
//Space complexity: O(1)

package Leetcode;

public class MiddleOfTheLinkedList {

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
        // head.next.next.next.next.next = new ListNode(6);
        ListNode middle = middleNode(head);
        System.out.println(middle.val);
    }

    public static ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < n / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
