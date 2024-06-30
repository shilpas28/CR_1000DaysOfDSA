//GFG
//Delete node in Doubly Linked List
//Time complexity: O(N)
//Space complexity: O(1) 

public class DeleteNodeInDoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int x) {
            data = x;
            next = null;
            prev = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.prev = head;
        head.next.next = new Node(4);
        head.next.next.prev = head.next;
        int x = 3;
        printlist(head);
        Node newhead = deleteNode(head, x);
        printlist(newhead);
    }

    public static Node deleteNode(Node head, int x) {
        if (x == 1)
            return head.next;
        int count = 1;
        Node temp = head;
        while (count < x) {
            temp = temp.next;
            count++;
        }
        temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
        return head;
    }

    static void printlist(Node res) {
        Node currNode = res;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
}
