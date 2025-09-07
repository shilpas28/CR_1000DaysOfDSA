//GFG
//Merge K sorted linked lists - Merging Lists Two At a Time
//Time complexity: O( N*k(k+1)/2) ~ O(N*k^2)
//Space complexity: O(1) as no additional data structures or space is allocated for storing data, only a constant space for pointers 
//to maintain for traversing the linked list and merging them in place.

public class MergeKSortedLinkedLists_2 {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(7);
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(8);
        Node head3 = new Node(9);
        Node[] arr = new Node[3];
        arr[0] = head1;
        arr[1] = head2;
        arr[2] = head3;
        Node res = mergeKLists(arr);
        printList(res);
    }

    // Function to merge K sorted linked list.
    static Node mergeKLists(Node[] arr) {
        // code here
        // Consider the first linked list
        // as the starting point for merging
        Node head = arr[0];
        // Loop through the remaining
        // linked lists in the 'listArray'
        for (int i = 1; i < arr.length; i++) {
            // Merge the current 'head' linked
            // list with the next linked list
            head = mergeTwoSortedLinkedLists(head, arr[i]);
        }
        // Return the head of
        // the merged linked lists
        return head;
    }

    // Function to merge two sorted linked lists
    public static Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
        // Create a dummy node to serve
        // as the head of the merged list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare elements of both lists and
            // link the smaller node to the merged list
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer to the next node
            temp = temp.next;
        }
        // If any list still has remaining
        // elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        // Return the merged list starting
        // from the next of the dummy node
        return dummyNode.next;
    }

    static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data);

            if (head.next != null)
                System.out.print("->");

            head = head.next;
        }
    }
}
