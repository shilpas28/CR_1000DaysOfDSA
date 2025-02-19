//GFG
//Merge K sorted linked lists - Merging Lists Two At a Time
//Time complexity: O( N*k(k+1)/2) ~ O(N*k^2)
//Space complexity: O(1) as no additional data structures or space is allocated for storing data, only a constant space for pointers 
//to maintain for traversing the linked list and merging them in place.

package GFG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeKSortedLinkedLists_2 {

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
            MergeKSortedLinkedLists_2 sol = new MergeKSortedLinkedLists_2();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
    }

    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        // Consider the first linked list
        // as the starting point for merging
        Node head = arr.get(0);
        // Loop through the remaining
        // linked lists in the 'listArray'
        for (int i = 1; i < arr.size(); i++) {
            // Merge the current 'head' linked
            // list with the next linked list
            head = mergeTwoSortedLinkedLists(head, arr.get(i));
        }
        // Return the head of
        // the merged linked lists
        return head;
    }

    // Function to merge two sorted linked lists
    public static Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
        // Create a dummy node to serve
        // as the head of the merged list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare elements of both lists and
            // link the smaller node to the merged list
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer to the next node
            temp = temp.next;
        }
        // If any list still has remaining
        // elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        // Return the merged list starting
        // from the next of the dummy node
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
