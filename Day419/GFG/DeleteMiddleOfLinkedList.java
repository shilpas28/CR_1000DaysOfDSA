//GFG
//Delete Middle of Linked List - Brute Force method
//Time complexity: O(N) - O(N + N/2) The loop traverses the entire linked list once to count the total number of nodes then the 
//loop iterates halfway through the linked list to reach the middle node. Hence, the time complexity is O(N + N/2) ~ O(N).
//Space complexity: O(1) - The algorithm uses a constant amount of extra space regardless of the size of the 
//input (linked list). It doesn't use any additional data structures in proportion to the input size. Thus, the space complexity 
//is O(1) (constant space). 

package GFG;

@SuppressWarnings("all")
public class DeleteMiddleOfLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.next = new Node(4);
        root.next.next = new Node(6);
        root.next.next.next = new Node(7);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(1);
        Node res = deleteMid(root);
        printList(res);
    }

    static Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        // Initialize a temporary node
        // to traverse the linked list
        Node temp = head;

        // Variable to hold the number
        // of nodes in the linked list
        int n = 0;

        // Loop to count the number of
        // nodes in the linked list
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Calculate the index of the middle node
        int res = n / 2;

        // Reset the temporary node to
        // the beginning of the linked list
        temp = head;

        // Loop to find the
        // middle node to delete
        while (temp != null) {

            res--;

            // If the middle node is found
            if (res == 0) {

                // Create a pointer
                // to the middle node
                Node middle = temp.next;

                // Adjust pointers to
                // skip the middle node
                temp.next = temp.next.next;

                // No need to explicitly free memory in Java,
                // as it's managed by the garbage collector

                // Exit the loop after
                // deleting the middle node
                break;
            }
            // Move to the next node
            // in the linked list
            temp = temp.next;
        }
        // Return the head of the
        // modified linked list
        return head;
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
