//GFG
//Remove loop in Linked List - Better Method
//Time complexity: O(N)
//Space complexity: O(1) 

public class RemoveLoopInLinkedList_2 {

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

        Node ptr1 = slow;
        Node ptr2 = slow;
        // step 2
        int x = 1;
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
            x++;
        }
        // step 3
        ptr1 = head; // move one pointer to head
        ptr2 = head;
        for (int i = 0; i < x; i++) {
            ptr2 = ptr2.next; // move one pointer to xth node from head;
        }
        // step 4
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // step 5
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
