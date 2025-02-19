//GFG
//Merge K sorted linked lists - Brute Force
//Time complexity: O(K*N) + O((N*K) * log(N*K)) + O(N*K) where K is the number of linked lists and N is the length of each linked list.
//Space complexity: O(N*K) + O(N*K) where K is the number of linked lists and N is the length of each linked list.

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MergeKSortedLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.next = newNode;
                        temp = temp.next;
                    }
                }

                lists.add(head);
            }
            MergeKSortedLinkedLists sol = new MergeKSortedLinkedLists();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
    }

    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        // Create an ArrayList to store node values
        ArrayList<Integer> arry = new ArrayList<>();
        // Iterate through the listArray containing all linked lists
        for (int i = 0; i < arr.size(); i++) {
            // Initialize a temporary pointer to the head of the current linked list
            Node temp = arr.get(i);
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

    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
