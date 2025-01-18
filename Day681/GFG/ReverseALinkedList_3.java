//GFG
//Reverse a linked list
//Time complexity: O(N)
//Space complexity: O(N) - using space for recursive call stack

package GFG;

public class ReverseALinkedList_3 {

    static class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node res = reverseList(head);
        printlist(res);
    }

    static Node reverseList(Node head) {
        // code here
        return reverseListHelper(head, null);
    }

    public static Node reverseListHelper(Node curr, Node prev) {
        // base case
        if (curr == null)
            return prev;

        Node next = curr.next;
        curr.next = prev;
        return reverseListHelper(next, curr);
    }

    static void printlist(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
