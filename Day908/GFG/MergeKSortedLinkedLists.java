//GFG
//Merge K sorted linked lists - Brute Force
//Time complexity: O(K*N) + O((N*K) * log(N*K)) + O(N*K) where K is the number of linked lists and N is the length of each linked list.
//Space complexity: O(N*K) + O(N*K) where K is the number of linked lists and N is the length of each linked list.

import java.util.ArrayList;
import java.util.Collections;

public class MergeKSortedLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(7);
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(8);
        Node head3 = new Node(9);
        Node[] arr = new Node[3];
        arr[0] = head1;
        arr[1] = head2;
        arr[2] = head3;
        Node res = mergeKLists(arr);
        printList(res);
    }

    // Function to merge K sorted linked list.
    static Node mergeKLists(Node[] arr) {
        // code here
        // Create an ArrayList to store node values
        ArrayList<Integer> arry = new ArrayList<>();
        // Iterate through the listArray containing all linked lists
        for (int i = 0; i < arr.length; i++) {
            // Initialize a temporary pointer to the head of the current linked list
            Node temp = arr[i];
            // Traverse through the current linked list
            while (temp != null) {
                // Store the data of each node in the ArrayList
                arry.add(temp.data);
                // Move to the next node in the linked list
                temp = temp.next;
            }
        }
        // Sort the ArrayList containing node values in ascending order
        Collections.sort(arry);
        // Convert the sorted ArrayList back to a linked list and return its head
        return convertArrToLinkedList(arry);
    }

    // Function to convert an ArrayList to a linked list
    static Node convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve as the head of the linked list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        // Iterate through the ArrayList and create nodes with elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the ArrayList element
            temp.next = new Node(arr.get(i));
            // Move the temporary pointer to the newly created node
            temp = temp.next;
        }
        // Return the linked list starting from the next of the dummy node
        return dummyNode.next;
    }

    static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data);

            if (head.next != null)
                System.out.print("->");

            head = head.next;
        }
    }
}
