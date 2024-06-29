//GFG
//Identical Linked Lists
//Time complexity: O(N)
//Space complexity: O(1)

public class IdenticalLinkedLists {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);

        Node head2 = new Node(99);
        head2.next = new Node(59);
        head2.next.next = new Node(42);
        head2.next.next.next = new Node(20);

        System.out.println(areIdentical(head1, head2));
    }

    // Function to check whether two linked lists are identical or not.
    public static boolean areIdentical(Node head1, Node head2) {
        // write your code here
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null || head2 != null)
            return false;
        return true;
    }
}
