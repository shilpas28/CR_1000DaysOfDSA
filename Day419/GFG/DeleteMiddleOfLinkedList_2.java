//GFG
//Delete Middle of Linked List - Optimal method - Using slow and fast pointers
//Time complexity: O(N) - O(N/2) The algorithm traverses the linked list using the Tortoise and Hare approach. The code 
//increments both 'slow' and 'fast' pointers at different rates, effectively covering about half the list before reaching the 
//midpoint, hence the time complexity of the algorithm is O(N/2) ~ O(N).
//Space complexity: O(1) - The algorithm uses a constant amount of extra space regardless of the size of the input (linked list).
// It doesn't use any additional data structures in proportion to the input size. Thus, the space complexity 
//is O(1) (constant space). 

package GFG;

public class DeleteMiddleOfLinkedList_2 {

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
        /*
         * If the list is empty or has only one node,
         * return null as there is no middle node to delete
         */
        if (head == null || head.next == null) {
            return null;
        }
        // Initialize slow and fast pointers
        Node slow = head;
        Node fast = head;
        fast = head.next.next;
        // Move 'fast' pointer twice as fast as 'slow'
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Delete the middle node by skipping it
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
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
