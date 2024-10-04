//GFG
//Deletion and Reverse in Circular Linked List
//Time complexity: O(N)
//Space complexity: O(1) 

public class DeletionAndReverseInCircularLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.next = new Node(5);
        root.next.next = new Node(7);
        root.next.next.next = new Node(8);
        root.next.next.next.next = new Node(10);
        root.next.next.next.next.next = root;
        int key = 8;
        Node res = reverse(root);
        deleteNode(res, key);
    }

    // Function to reverse a circular linked list
    static Node reverse(Node head) {
        // code here
        Node curr = head.next, nxt = null, prev = head;
        while (curr != head) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head.next = prev;
        return prev;
    }

    // Function to delete a node from the circular linked list
    static Node deleteNode(Node head, int key) {
        // code here
        Node temp = head.next, prev = head;
        if (head.data == key) {
            while (temp != head) {
                prev = temp;
                temp = temp.next;
            }
        } else {
            while (temp != head && temp.data != key) {
                prev = temp;
                temp = temp.next;
            }
        }
        if (head.data == key || temp != head)
            prev.next = temp.next;
        return head.data == key ? prev.next : head;
    }

}
