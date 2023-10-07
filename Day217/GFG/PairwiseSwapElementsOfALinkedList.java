//GFG
//Pairwise swap elements of a linked list
//Time Complexity: O(N)
//Space Complexity: O(1)

package GFG;

public class PairwiseSwapElementsOfALinkedList {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        Node res = pairwiseSwap(head);
        printList(res);
    }

    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public static Node pairwiseSwap(Node head) {
        // code here
        if (head == null || head.next == null)
            return head;
        Node temp = head.next;
        head.next = pairwiseSwap(temp.next);
        temp.next = head;
        return temp;
    }

    public static void printList(Node head) {
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
