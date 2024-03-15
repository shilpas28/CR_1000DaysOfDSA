//GFG
//Linked List that is Sorted Alternatingly
//Time complexity: O(NlogN)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class LinkedListThatIsSortedAlternatingly {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(9);
        root.next.next = new Node(2);
        root.next.next.next = new Node(8);
        root.next.next.next.next = new Node(3);
        root.next.next.next.next.next = new Node(7);
        Node res = sort(root);
        printList(res);
    }

    public static Node sort(Node head) {
        // your code here, return the head of the sorted list
        if (head == null || head.next == null)
            return head;
        ArrayList<Integer> a = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            a.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(a);
        Node copy = head;
        for (Integer i : a) {
            copy.data = i;
            copy = copy.next;
        }
        return head;
    }

    static void printList(Node head) {
        Node currNode = head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
