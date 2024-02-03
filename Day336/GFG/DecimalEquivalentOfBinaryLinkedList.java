//GFG
//Decimal Equivalent of Binary Linked List
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class DecimalEquivalentOfBinaryLinkedList {

    // Node of a linked list
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Linked List class
    static class LinkedList {
        Node head; // head of list
    }

    public static void main(String[] args) {
        // n = 3
        // Linked List = {0, 1, 1}
        LinkedList ll = new LinkedList();
        ll.head = new Node(0);
        ll.head.next = new Node(1);
        ll.head.next.next = new Node(1);
        System.out.println(DecimalValue(ll.head));
    }

    static long DecimalValue(Node head) {
        long MOD = 1000000007;
        // Variable to store the resulting decimal value;
        long result = 0;
        // Iterating through the linked list
        while (head != null) {
            // Calculating the result by multiplying it with 2, taking modulo with MOD and adding the data of the current head
            //Also use modular division to ensure the result doesn't exceed the maximum value
            result = ((result << 1) % MOD + head.data % MOD) % MOD;
            // Moving to the next node in the linked list
            head = head.next;
        }
        // Returning the final decimal value
        return result;
    }

}
