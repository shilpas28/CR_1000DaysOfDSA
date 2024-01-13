//GFG
//Insertion Sort for Singly Linked List
//Time complexity: O(N^2)
//Space complexity: O(1) 

package GFG;

public class InsertionSortForSinglyLinkedList_2 {

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

    static Node ans;

    public static Node insertionSort(Node head_ref) {
        // code here
        ans = null;
        Node temp = head_ref;
        while (temp != null) {
            Node next = temp.next;
            insertInans(temp);
            temp = next;
        }
        head_ref = ans;
        return head_ref;
    }

    public static void insertInans(Node temp) {
        if (ans == null || ans.data > temp.data) {
            temp.next = ans;
            ans = temp;
        } else {
            Node curr = ans;
            while (curr.next != null && curr.next.data <= temp.data)
                curr = curr.next;
            temp.next = curr.next;
            curr.next = temp;
        }
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
