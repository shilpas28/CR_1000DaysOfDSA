//GFG
//Merge Sort on Doubly Linked List
//Time complexity: O(nlogn)
//Space complexity: O(logn)

package GFG;

public class MergeSortOnDoublyLinkedList {

    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(3);
        head.prev = null;
        head.next.next = new Node(5);
        head.next.prev = head;
        head.next.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next.next = new Node(6);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        head.next.next.next.next.next.next.next.next = null;
        head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;
        Node res = sortDoubly(head);
        printList(res);
    }

    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // add your code here
        if (head == null || head.next == null) { // empty or one node.
            return head;
        }
        /// split in two halves recursively
        Node h2 = funsplit(head);
        head = sortDoubly(head);
        h2 = sortDoubly(h2);

        return merge(head, h2);
    }

    static Node funsplit(Node h1) {
        Node fast = h1, slow = h1;
        while (fast.next != null && fast.next.next != null) { // odd and even case
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

    static Node merge(Node h1, Node h2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        while (h1 != null && h2 != null) { // till both list exist.
            if (h1.data < h2.data) {
                curr.next = h1;
                h1.prev = curr;

                h1 = h1.next;
            } else {
                curr.next = h2;
                h2.prev = curr;

                h2 = h2.next;
            }
            curr = curr.next;
        }
        // iterating in remaining ele in h1 list
        if (h1 != null) {
            curr.next = h1;
            h1.prev = curr;
        }
        if (h2 != null) {
            curr.next = h2;
            h2.prev = curr;
        }

        Node ans = dummy.next;
        ans.prev = null;
        return ans;
    }

    static void printList(Node head) {
        // Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            // Prints each node by incrementing the pointer.
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
