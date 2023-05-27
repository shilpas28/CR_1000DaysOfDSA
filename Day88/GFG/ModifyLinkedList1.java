//GFG
//Modify Linked List-1
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class ModifyLinkedList1 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // int N = 5;
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(6);
        modifyTheList(head);
        printList(head);
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static Node modifyTheList(Node head) {
        int len = 0;
        Node temp = head, pichli = null;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len % 2 == 1)
            len++;
        len = len / 2;
        len++;
        int c = 1;
        temp = head;
        while (c != len) {
            pichli = temp;
            temp = temp.next;
            c++;
        }
        Node curr = temp, prev = null, agli;
        while (curr != null) {
            agli = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agli;
        }
        pichli.next = prev;
        Node first = head, second = prev;
        while (second != null) {
            int t = first.data;
            first.data = second.data - first.data;
            second.data = t;
            second = second.next;
            first = first.next;
        }
        curr = pichli.next;
        prev = null;
        while (curr != null) {
            agli = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agli;
        }
        pichli.next = prev;
        return head;
    }
}
