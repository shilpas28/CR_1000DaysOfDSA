//GFG
//Middle of a Linked List - Brute Force
//Time complexity: O(N+N/2) The code traverses the entire linked list once and half times and then only half in the second 
//iteration, first to count the number of nodes then then again to get to the middle node. Therefore, the time complexity is 
//linear, O(N + N/2) ~ O(N).
//Space complexity: O(1) There is constant space complexity because it uses a constant amount of extra space regardless of the 
//size of the linked list. We only use a few variables to keep track of the middle position and traverse the list, and the memory 
//required for these variables does not depend on the size of the list.

public class MiddleOfALinkedList {

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
        // If the list is empty or has
        // only one element, return the head as
        // it's the middle.
        if (head == null || head.next == null) {
            return head.data;
        }
        Node temp = head;
        int count = 0;
        // Count the number of nodes
        // in the linked list.
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        // Calculate the position of the middle node.
        int mid = count / 2 + 1;
        temp = head;

        while (temp != null) {
            mid = mid - 1;
            // Check if the middle
            // position is reached.
            if (mid == 0) {
                // break out of the loop
                // to return temp
                break;
            }
            // Move temp ahead
            temp = temp.next;
        }
        // Return the middle node.
        return temp.data;
    }
}
