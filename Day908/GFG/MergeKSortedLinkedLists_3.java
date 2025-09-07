//GFG
//Merge K sorted linked lists
//Time complexity: O(K log K) + O(N*K*(3*log K))where K is the number of linked lists and N is the number of nodes in each list.
//Space complexity: O(K) where K is the number of linked lists.

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists_3 {

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
        // Priority queue to maintain
        // sorted order based on node values
        // Pairs store node value and pointer to the node
        PriorityQueue<Map.Entry<Integer, Node>> pq = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getKey));
        // Push the heads of all the
        // linked lists into the priority queue
        for (Node node : arr) {
            // Check if the current linked list exists
            if (node != null) {
                // Push the pair of node data and
                // node pointer into the priority queue
                pq.add(new AbstractMap.SimpleEntry<>(node.data, node));
            }
        }
        // Create a dummy node to build the merged list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        // Merge the lists present
        // in the priority queue
        while (!pq.isEmpty()) {
            // Get the top element (minimum node value)
            // from the priority queue
            Map.Entry<Integer, Node> it = pq.poll();
            // Check if the current
            // node has a next node
            if (it.getValue().next != null) {
                // Push the next node
                // into the priority queue
                pq.add(new AbstractMap.SimpleEntry<>(it.getValue().next.data, it.getValue().next));
            }
            // Set the next pointer of the
            // current node in the merged list
            temp.next = it.getValue();
            temp = temp.next;
        }
        // Return the merged linked list
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
