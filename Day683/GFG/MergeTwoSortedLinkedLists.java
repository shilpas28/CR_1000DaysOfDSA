//GFG
//Merge two sorted linked lists - Brute Force
/* 
Time complexity: O(N1 + N2) + O(N log N) + O(N) where N1 is the number of linked list nodes in the first list and N2 is the 
number of linked list nodes in the second list and N is the total number of nodes (N1+N2). Traversing both lists into the array 
owes O(N1 + N2), sorting the array takes O((N1+N2)*log(N1+N2)) and then traversing the sorted array and creating a list gives us 
another O(N1+N2) 
Space complexity: O(N)+O(N) where N is the total number of nodes from both lists, N1 + N2. O(N) to store all the nodes of both 
the lists in an external array and another O(N) to create a new combined list.
*/

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);
        Node res = sortedMerge(head1, head2);
        printList(res);
    }

    static Node sortedMerge(Node head1, Node head2) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp1 = head1;
        Node temp2 = head2;
        // Storing elements of both lists into an array
        // Add elements from list1 to the array
        while (temp1 != null) {
            arr.add(temp1.data);
            // Move to the next node in list1
            temp1 = temp1.next;
        }
        // Add elements from list2 to the array
        while (temp2 != null) {
            arr.add(temp2.data);
            // Move to the next node in list2
            temp2 = temp2.next;
        }
        // Sorting the array in ascending order
        Collections.sort(arr);
        // Converting the sorted array
        // back to a linked list
        Node head = convertArrToLinkedList(arr);
        // Return the head of the
        // merged sorted linked list
        return head;
    }

    // Function to convert an array to a linked list
    static Node convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve
        // as the head of the linked list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        // Iterate through the array and
        // create nodes with array elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the array element
            temp.next = new Node(arr.get(i));
            // Move the temporary pointer to the newly created node
            temp = temp.next;
        }
        // Return the linked list starting
        // from the next of the dummy node
        return dummyNode.next;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
