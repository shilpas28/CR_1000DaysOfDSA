//GFG
//Decimal Equivalent of Binary Linked List
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class DecimalEquivalentOfBinaryLinkedList_2 {

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
        int mod = 1000000007;
        long ans = 0;
        while (head != null) {
            ans = (ans * 2 + head.data) % mod;
            head = head.next;
        }
        return ans;
    }
}
