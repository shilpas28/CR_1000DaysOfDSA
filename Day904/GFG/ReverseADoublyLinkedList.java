//GFG
//Reverse a Doubly Linked List
//Time complexity: O(N)
//Space complexity: O(1)

public class ReverseADoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(75);
        root.prev = null;
        root.next = new Node(122);
        root.next.prev = root;
        root.next.next = new Node(59);
        root.next.next.prev = root.next;
        root.next.next.next = new Node(196);
        root.next.next.next.prev = root.next.next;
        root.next.next.next.next = null;
        Node newRoot = reverse(root);
        printDLL(newRoot);
    }

    public static Node reverse(Node head) {
        // code here
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        Node prev = null; // temporary variable for swapping;
        while (curr != null) {
            // Swap prev and next variables
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            // Next is now prev and not curr becoz prev and next have been swapped
            curr = curr.prev;
        }
        return prev.prev;
    }

    static void printDLL(Node newRoot) {
        Node currNode = newRoot;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
        System.out.println();
    }
}
