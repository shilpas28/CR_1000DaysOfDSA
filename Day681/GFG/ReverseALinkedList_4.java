//GFG
//Reverse a linked list
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class ReverseALinkedList_4 {

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
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
