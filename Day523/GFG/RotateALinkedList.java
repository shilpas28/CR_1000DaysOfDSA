//GFG
//Rotate a Linked List
//Time complexity: O(N)
//Space complexity: O(1)

public class RotateALinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        // 2->4->7->8->9 , k = 3
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(9);
        int k = 3;
        Node res = rotate(head, k);
        printLinkedList(res);
    }

    // Function to rotate a linked list.
    public static Node rotate(Node head, int k) {
        // add code here
        Node curr = head;
        int kCnt = 1;
        while (kCnt < k && curr != null) {
            curr = curr.next;
            ++kCnt;
        }

        if (curr == null)
            return head;

        Node kthNode = curr;
        while (curr.next != null)
            curr = curr.next;

        curr.next = head;
        head = kthNode.next;
        kthNode.next = null;
        return head;
    }

    static void printLinkedList(Node head) {
        Node currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
