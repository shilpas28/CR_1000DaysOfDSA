//GFG
//Find the first node of loop in linked list - Brute Force
//Time complexity: O(N) The code traverses the entire linked list once, where 'N' is the number of nodes in the list. Therefore, 
//the time complexity is linear, O(N).
//Space complexity: O(N) The code uses a hash map/dictionary to store encountered nodes, which can take up to O(N) additional 
//space, where 'n' is the number of nodes in the list. Hence, the space complexity is O(N) due to the use of the map to track nodes.

package GFG;

import java.util.HashMap;

public class FindTheFirstNodeOfLoopInLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;
        Node res = findFirstNode(head);
        System.out.println(res.data);
    }

    public static Node findFirstNode(Node head) {
        // code here
        // Use temp to traverse the linked list
        Node temp = head;
        // HashMap to store all visited nodes
        HashMap<Node, Integer> nodeMap = new HashMap<>();
        // Traverse the list using temp
        while (temp != null) {
            // Check if temp has been encountered again
            if (nodeMap.containsKey(temp)) {
                // A loop is detected, hence return temp
                return temp;
            }
            // Store temp as visited
            nodeMap.put(temp, 1);
            // Iterate through the list
            temp = temp.next;
        }
        // If no loop is detected, return null
        return null;
    }
}
