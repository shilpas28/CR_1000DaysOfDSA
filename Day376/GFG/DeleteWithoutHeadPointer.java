//GFG
//Delete without head pointer
//Time complexity: O(1)
//Space complexity: O(1) 

package GFG;

public class DeleteWithoutHeadPointer {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(4);
        head.next.next.next = new Node(30);
        Node del_node = head.next;
        printList(head);
        deleteNode(del_node);
        printList(head);
    }

    static void deleteNode(Node del_node) {
        // Your code here
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
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
