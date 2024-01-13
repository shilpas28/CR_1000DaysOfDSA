//GFG
//Insertion Sort for Singly Linked List
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class InsertionSortForSinglyLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(30);
        head.next = new Node(23);
        head.next.next = new Node(28);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(11);
        head.next.next.next.next.next = new Node(14);
        head.next.next.next.next.next.next = new Node(19);
        head.next.next.next.next.next.next.next = new Node(16);
        head.next.next.next.next.next.next.next.next = new Node(21);
        head.next.next.next.next.next.next.next.next.next = new Node(25);

        Node res = insertionSort(head);
        printList(res);
    }

    public static Node insertionSort(Node head_ref) {
        // code here
        if (head_ref == null || head_ref.next == null)
            return head_ref;
        Node sortedHead = new Node(-1);
        Node cur = head_ref;
        while (cur != null) {
            Node nextNode = cur.next;
            Node dummy = sortedHead;
            while (dummy.next != null && dummy.next.data <= cur.data) {
                dummy = dummy.next;
            }
            cur.next = dummy.next;
            dummy.next = cur;
            cur = nextNode;
        }
        return sortedHead.next;
    }

    static void printList(Node head) {
        Node currNode = head;
        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
}
