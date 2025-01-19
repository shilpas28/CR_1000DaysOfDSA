//GFG
//Rotate a Linked List
//Time complexity: O(N)
//Space complexity: O(1)

public class RotateALinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        int k = 4;
        Node res = rotate(head, k);
        printList(res);
    }

    public static Node rotate(Node head, int k) {
        // add code here
        int len = 1;
        Node tmp = head;
        while (tmp.next != null) {
            len++;
            tmp = tmp.next;
        }
        k = k % len;
        if (k == 0)
            return head;
        tmp.next = head;
        tmp = head;
        for (int i = 1; i < k; i++) {
            tmp = tmp.next;
        }
        head = tmp.next;
        tmp.next = null;
        return head;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
