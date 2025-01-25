//GFG
//Find the first node of loop in linked list - Optimal
//Time complexity: O(N) - The code traverses the entire linked list once, where 'n' is the number of nodes in the list. This 
//traversal has a linear time complexity, O(n).
//Space complexity: O(1) - The code uses only a constant amount of additional space, regardless of the linked list's length. This is 
//achieved by using two pointers (slow and fast) to detect the loop without any significant extra memory usage, resulting in 
//constant space complexity, O(1).

package GFG;

public class FindTheFirstNodeOfLoopInLinkedList_2 {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;
        Node res = findFirstNode(head);
        System.out.println(res.data);
    }

    public static Node findFirstNode(Node head) {
        // code here
        // Initialize a slow and fast
        // pointers to the head of the list
        Node slow = head;
        Node fast = head;
        // Phase 1: Detect the loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;
            // If slow and fast meet,
            // a loop is detected
            if (slow == fast) {
                // Reset the slow pointer
                // to the head of the list
                slow = head;
                // Phase 2: Find the first node of the loop
                while (slow != fast) {
                    // Move slow and fast one step
                    // at a time
                    slow = slow.next;
                    fast = fast.next;
                    // When slow and fast meet again,
                    // it's the first node of the loop
                }
                // Return the first node of the loop
                return slow;
            }
        }
        // If no loop is found, return null
        return null;
    }
}
