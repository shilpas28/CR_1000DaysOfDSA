//GFG
//Insertion Sort for Singly Linked List
//Time complexity: O(N^2)
//Space complexity: O(1) 

package GFG;

import java.util.PriorityQueue;

public class InsertionSortForSinglyLinkedList_3 {

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
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        Node temp = head_ref;
        while (temp != null) {
            pq.add(temp.data);
            temp = temp.next;
        }
        Node s = new Node(-1);
        Node ans = s;
        while (pq.size() != 0) {
            s.next = new Node(pq.remove());
            s = s.next;
        }
        return ans.next;
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
