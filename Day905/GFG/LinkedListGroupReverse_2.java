//GFG
//Linked List Group Reverse - Iterative
//Time complexity: O(N)
//Space complexity: O(1)

public class LinkedListGroupReverse_2 {

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
        Node nn = head;
        Node ans = new Node(-1);
        Node ansPtr = ans;
        while (nn != null) {
            Node start = nn;
            Node end = nn;
            int cnt = k;
            while (end != null && cnt != 1) {
                end = end.next;
                cnt--;
            }
            if (end != null) {
                nn = end.next;
                end.next = null;
            } else {
                nn = null;
            }
            ansPtr.next = reverseList(start);
            ansPtr = start;
        }
        return ans.next;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node next = null;
        Node ptr = head;
        while (ptr != null) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
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
