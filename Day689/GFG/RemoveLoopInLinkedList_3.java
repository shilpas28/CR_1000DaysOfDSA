//GFG
//Remove loop in Linked List - Optimal Method (Failing for GFG)
//Time complexity: O(N)
//Space complexity: O(1)

public class RemoveLoopInLinkedList_3 {

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
        head.next.next = new Node(4);
        head.next.next.next = head.next;
        removeLoop(head);
        printList(head);
    }

    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast)
            return;
        // Loop Removal Algorithm
        slow = head;
        // checking for intersection of two pointers
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        // loop termination
        fast.next = null;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
