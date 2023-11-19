//GFG
//Intersection of two sorted Linked lists
//Time complexity: O(n+m)
//Space complexity: O(n+m) 

import java.util.HashMap;

public class IntersectionOfTwoSortedLinkedLists {

    // Node of a linked list
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        Node res = findIntersection(head1, head2);
        printDLL(res);
    }

    public static Node findIntersection(Node head1, Node head2) {
        // code here.
        Node result = null;
        Node curr = null;

        HashMap<Integer, Integer> set = new HashMap<>();
        while (head1 != null) {
            set.put(head1.data, set.getOrDefault(head1.data, 0) + 1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (set.containsKey(head2.data) && set.get(head2.data) > 0) {
                set.put(head2.data, set.get(head2.data) - 1);
                if (result == null) {
                    result = new Node(head2.data);
                    curr = result;
                } else {
                    curr.next = new Node(head2.data);
                    curr = curr.next;
                }
            }
            head2 = head2.next;
        }
        return result;
    }

    static void printDLL(Node newRoot) {
        Node currNode = newRoot;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
        System.out.println();
    }

}
