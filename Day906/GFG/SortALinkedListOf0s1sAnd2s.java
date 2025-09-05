//GFG
//Sort a linked list of 0s, 1s and 2s
//Time complexity: O(N)
//Space complexity: O(1)

public class SortALinkedListOf0s1sAnd2s {

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
        int cnt[] = new int[3];
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.data == 0)
                cnt[0]++;
            else if (curr.data == 1)
                cnt[1]++;
            else
                cnt[2]++;
        }
        Node curr = head;
        int idx = 0;
        while (curr != null) {
            if (cnt[idx] == 0)
                idx++;

            if (cnt[idx] != 0) {
                curr.data = idx;
                cnt[idx]--;
                curr = curr.next;
            }
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
