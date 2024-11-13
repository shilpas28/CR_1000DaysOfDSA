//GFG
//Intersection Point in Y Shaped Linked Lists
//Time complexity: O(n+m)
//Space complexity: O(1)

package GFG;

public class IntersectionPointInYShapedLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(1);
        head1.next.next = new Node(8);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = new Node(4);
        head2.next.next.next.next.next = new Node(5);

        System.out.println(intersectPoint(head1, head2));
    }

    // Function to find intersection point in Y shaped Linked Lists.
    static int intersectPoint(Node head1, Node head2) {
        // code here
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : head2;
            p2 = p2 != null ? p2.next : head1;
        }
        return p1 != null ? p1.data : -1;
    }
}
