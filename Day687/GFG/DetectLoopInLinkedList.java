//GFG
//Detect Loop in linked list - Brute Force 
//Time complexity: O(N * 2 * log(N) ) - The algorithm traverses the linked list once, performing hashmap insertions and searches in
//the while loop for each node. The insertion and search operations in the unordered_map have a worst-case time complexity 
//of O(log(N)). As the loop iterates through N nodes, the total time complexity is determined by the product of the 
//traversal (O(N)) and the average-case complexity of the hashmap operations (insert and search), resulting in O(N * 2 * log(N)).
//Space complexity: O(N) - The code uses a hashmap/dictionary to store encountered nodes, which can take up to O(N) additional 
//space, where 'n' is the number of nodes in the list. Hence, the spacecomplexity is O(N) due to the use of the map to track nodes.

import java.util.*;

public class DetectLoopInLinkedList {

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
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;
        System.out.println(detectLoop(head));
    }

    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        // Initialize a pointer 'temp'
        // at the head of the linked list
        Node temp = head;
        int value = 1;
        // Create a map to keep track
        // of encountered nodes
        Map<Node, Integer> nodeMap = new HashMap<>();
        // Step 2: Traverse the linked list
        while (temp != null) {
            // If the node is already in
            // the map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node in the map
            nodeMap.put(temp, Integer.valueOf(value));
            // Move to the next node
            temp = temp.next;
        }
        // Step 3: If the list is successfully
        // traversed without a loop, return false
        return false;
    }
}
