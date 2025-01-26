//GFG
//Remove loop in Linked List - Brute Force
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.HashSet;
import java.util.Set;

public class RemoveLoopInLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;
        removeLoop(head);
        printList(head);
    }

    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        Set<Node> set = new HashSet<>();
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (set.contains(current)) // loop detected
            {
                prev.next = null; // loop removal
                return;
            }
            set.add(current);

            prev = current;
            current = current.next;
        }
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
