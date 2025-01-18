//GFG
//Reverse a linked list
//Time complexity: O(N)
//Space complexity: O(N) - using space for recursive call stack

package GFG;

public class ReverseALinkedList_2 {

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
        if (head == null || head.next == null)
            return head;

        Node new_head = reverseList(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return new_head;
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
