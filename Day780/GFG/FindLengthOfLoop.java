//GFG
//Find length of Loop
//Time complexity: O(N) - The code traverses the entire linked list at least once, where 'N' is the number of nodes in the list. 
//Therefore, the time complexity is linear, O(N).
//Space complexity: O(N) - The code uses a hashmap/dictionary to store encountered nodes, which can take up to O(N) additional space, 
//where ‘N' is the number of nodes in the list. Hence, the space complexity is O(N) due to the use of the map to track nodes.

import java.util.HashMap;
import java.util.Map;

public class FindLengthOfLoop {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(25);
        head.next = new Node(14);
        head.next.next = new Node(19);
        head.next.next.next = new Node(33);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(21);
        head.next.next.next.next.next.next = new Node(39);
        head.next.next.next.next.next.next.next = new Node(90);
        head.next.next.next.next.next.next.next.next = new Node(58);
        head.next.next.next.next.next.next.next.next.next = new Node(45);
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;
        System.out.println(countNodesinLoop(head));
    }

    // Function to find the length of a loop in the linked list.
    public static int countNodesinLoop(Node head) {
        // code here.
        // Hashmap to store visited nodes
        // and their timer values
        Map<Node, Integer> visitedNodes = new HashMap<>();
        // Initialize pointer to
        // raverse the linked list
        Node temp = head;
        // Initialize timer to
        // track visited nodes
        int timer = 0;
        // Traverse the linked list
        // till temp reaches null
        while (temp != null) {
            // If revisiting a node, return
            // the difference of timer values
            if (visitedNodes.containsKey(temp)) {
                // Calculate the length of the loop
                int loopLength = timer - visitedNodes.get(temp);

                // Return the length of the loop
                return loopLength;
            }
            // Store the current node and
            // its timer value in the hashmap
            visitedNodes.put(temp, timer);
            // Move to the next node
            temp = temp.next;
            // Increment the timer
            timer++;
        }
        // If traversal is completed and we
        // reach the end of the list (null),
        // means there is no loop
        return 0;
    }
}
