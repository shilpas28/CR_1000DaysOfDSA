//GFG
//Merge two sorted linked lists - Optimal
//Time complexity: O(N1+N2) where N1 is the number of nodes in the first linked list and N1 in the second linked list as we 
//traverse both linked lists in a single pass for merging without any additional loops or nested iterations.
//Space complexity: O(1) as no additional data structures or space is allocated for storing data, only a constant space for 
//pointers to maintain for traversing the linked list.

public class MergeTwoSortedLinkedLists_2 {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);
        Node res = sortedMerge(head1, head2);
        printList(res);
    }

    static Node sortedMerge(Node head1, Node head2) {
        // code here
        // Create a dummy node to serve
        // as the head of the merged list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        // Traverse both lists simultaneously
        while (head1 != null && head2 != null) {
            // Compare elements of both lists and
            // link the smaller node to the merged list
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            // Move the temporary pointer
            // to the next node
            temp = temp.next;
        }
        // If any list still has remaining
        // elements, append them to the merged list
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }
        // Return the merged list starting
        // from the next of the dummy node
        return dummyNode.next;
    }

    // Function to print the linked list
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.data + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
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
