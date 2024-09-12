//GFG
//Middle of a Linked List - Optimal 
//Time complexity: O(N/2) The algorithm requires the 'fast' pointer to reach the end of the list which it does after 
//approximately N/2 iterations (where N is the total number of nodes). Therefore, the maximum number of iterations needed to 
//find the middle node is proportional to the number of nodes in the list, making the time complexity linear, or O(N/2) ~ O(N).
//Space complexity: O(1) There is constant space complexity because it uses a constant amount of extra space regardless of the 
//size of the linked list. We only use a few variables to keep track of the middle position and traverse the list, and the memory 
//required for these variables does not depend on the size of the list.

public class MiddleOfALinkedList_2 {

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
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(getMiddle(head));
    }

    static int getMiddle(Node head) {
        // Your code here.
        // Initialize the slow pointer to the head.
        Node slow = head;
        // Initialize the fast pointer to the head.
        Node fast = head;
        // Traverse the linked list using
        // the Tortoise and Hare algorithm.
        while (fast != null && fast.next != null && slow != null) {
            // Move fast two steps.
            fast = fast.next.next;
            // Move slow one step.
            slow = slow.next;
        }
        // Return the slow pointer,
        // which is now at the middle node.
        return slow.data;
    }
}
