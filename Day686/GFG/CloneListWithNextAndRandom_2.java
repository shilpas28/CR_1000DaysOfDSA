//GFG
//Clone List with Next and Random - without extra space
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class CloneListWithNextAndRandom_2 {

    static class Node {
        int data;
        Node next;
        Node random;

        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(9);
        head.next.next.next.next = null;
        head.random = head.next.next;
        head.next.random = head.next.next;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;

        Node res = cloneLinkedList(head);
        printList(res);
    }

    public static Node cloneLinkedList(Node head) {
        // code here
        if (head == null)
            return null;

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyH = head.next;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }
        return copyH;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
