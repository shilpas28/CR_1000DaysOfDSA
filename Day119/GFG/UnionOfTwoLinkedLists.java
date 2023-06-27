//GFG
//Union of Two Linked Lists
//Time complexity: O((N+M)*Log(N+M))
//Space complexity: O(N+M)

package GFG;

public class UnionOfTwoLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(6);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(8);
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(2);
        findUnion(head, head2);
    }

    public static Node findUnion(Node head1, Node head2) {
        // Add your code here.
        Node merged = merge(head1, head2);
        Node sorted = sort(merged);
        return sorted;
    }

    public static Node merge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Node ans = null;
        if (a.data < b.data) {
            ans = a;
            ans.next = merge(a.next, b);
        } else if (b.data < a.data) {
            ans = b;
            ans.next = merge(a, b.next);
        } else {
            ans = a;
            ans.next = merge(a.next, b.next);
        }
        return ans;
    }

    public static Node sort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node mid = slow;
        Node nextToMid = mid.next;
        mid.next = null;
        Node first = sort(head);
        Node second = sort(nextToMid);
        Node ans = merge(first, second);
        return ans;
    }
}
