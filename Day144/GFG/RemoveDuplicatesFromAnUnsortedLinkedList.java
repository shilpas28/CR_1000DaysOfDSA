//GFG
//Remove duplicates from an unsorted linked list
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

import java.util.HashSet;

public class RemoveDuplicatesFromAnUnsortedLinkedList {

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
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        Node res = removeDuplicates(head);
        printList(res);
    }

    public static void printList(Node res) {
        Node currNode = res;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    // Function to remove duplicates from unsorted linked list.
    public static Node removeDuplicates(Node head) {
        // Your code here
        Node ansList = new Node(-1);
        Node ansptr = ansList;
        HashSet<Integer> st = new HashSet<>();
        while (head != null) {
            if (!st.contains(head.data)) {
                st.add(head.data);
                ansptr.next = head;
                ansptr = ansptr.next;
            }
            head = head.next;
        }
        ansptr.next = null;
        return ansList.next;
    }
}
