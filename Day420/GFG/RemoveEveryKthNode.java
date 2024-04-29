//GFG
//Remove every kth node
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class RemoveEveryKthNode {

    static class Node {
        Node next;
        int data;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        int k = 2;
        Node res = delete(head, k);
        printList(res);
    }

    /* You are required to complete this method */
    static Node delete(Node head, int k) {
        // Your code here
        if (k == 1)
            return null;
        Node temp = head, prev = null;
        int c = 1;
        while (temp != null) {
            if (c == k) {
                c = 0;
                prev.next = temp.next;
            } else
                prev = temp;
            c++;
            temp = temp.next;
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
