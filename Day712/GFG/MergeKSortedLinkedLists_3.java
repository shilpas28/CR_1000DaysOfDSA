//GFG
//Merge K sorted linked lists
//Time complexity: O(K log K) + O(N*K*(3*log K))where K is the number of linked lists and N is the number of nodes in each list.
//Space complexity: O(K) where K is the number of linked lists.

package GFG;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedLinkedLists_3 {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.next = newNode;
                        temp = temp.next;
                    }
                }

                lists.add(head);
            }
            MergeKSortedLinkedLists_3 sol = new MergeKSortedLinkedLists_3();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
    }

    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
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

    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
