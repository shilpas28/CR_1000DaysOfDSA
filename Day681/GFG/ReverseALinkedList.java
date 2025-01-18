//GFG
//Reverse a linked list
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;

public class ReverseALinkedList {

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
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (Node curr = head; curr != null; curr = curr.next) {
            arr.add(curr.data);
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            curr.data = arr.remove(arr.size() - 1);
        }
        return head;
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
