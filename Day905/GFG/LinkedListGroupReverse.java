//GFG
//Linked List Group Reverse - Recursive
//Time complexity: O(N)
//Space complexity: O(1)

public class LinkedListGroupReverse {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        int k = 4;
        Node res = reverseKGroup(head, k);
        printList(res);
    }

    public static Node reverseKGroup(Node head, int k) {
        // code here
        if (head == null)
            return null;
        Node prev = null;
        Node next = null;
        Node headptr = head;
        int cnt = k;
        while (headptr != null && cnt != 0) {
            next = headptr.next;
            headptr.next = prev;
            prev = headptr;
            headptr = next;
            cnt--;
        }
        head.next = reverseKGroup(headptr, k);
        return prev;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
