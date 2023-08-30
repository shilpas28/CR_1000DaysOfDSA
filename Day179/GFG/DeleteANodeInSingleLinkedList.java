//GFG
//Delete a Node in Single Linked List
//Time complexity: O(N)
//Space complexity: O(1)
 
package GFG;

public class DeleteANodeInSingleLinkedList {

    // Linklist node structure
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(9);
        int x = 2;
        Node res = deleteNode(head, x);
        Node currNode = res;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    static Node deleteNode(Node head, int x) {
        // Your code here
        if (x == 1)
            return head.next;
        Node ptr = head;
        Node prev = null;
        while (x > 1) {
            prev = ptr;
            ptr = ptr.next;
            x -= 1;
        }
        prev.next = ptr.next;
        return head;
    }
}
