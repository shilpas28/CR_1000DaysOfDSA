//GFG
//Sort a linked list of 0s, 1s and 2s
//Time complexity: O(N)
//Space complexity: O(1)

public class SortALinkedListOf0s1sAnd2s_2 {

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
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);
        Node res = segregate(head);
        printList(res);
    }

    public static Node segregate(Node head) {
        // code here
        int zero = 0, one = 0, two = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero++;
            } else if (curr.data == 1) {
                one++;
            } else {
                two++;
            }
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            if (zero != 0) {
                curr.data = 0;
                zero--;
            } else if (one != 0) {
                curr.data = 1;
                one--;
            } else if (two != 0) {
                curr.data = 2;
                two--;
            }
            curr = curr.next;
        }

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
