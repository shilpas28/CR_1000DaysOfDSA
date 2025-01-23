//GFG
//Clone List with Next and Random - with extra space
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class CloneListWithNextAndRandom {

    static class Node {
        int data;
        Node next;
        Node random;

        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.random = head.next.next;
        head.next = new Node(3);
        head.next.random = head.next.next;
        head.next.next = new Node(5);
        head.next.next.random = head.next.next.next.next;
        head.next.next.next = new Node(9);
        head.next.next.next.random = head.next.next;
        head.next.next.next.next = null;
        Node res = cloneLinkedList(head);
        printList(res);
    }

    public static Node cloneLinkedList(Node head) {
        // code here
        Map<Node, Node> nodeMapping = new HashMap<>();
        // Dummy node to start building the cloned list
        Node dummyNode = new Node(0);
        Node currentOriginalNode = head;
        Node currentClonedNode = dummyNode;
        // Step 1: Create a clone of the linked list with only next pointers
        while (head != null) {
            Node clonedNode = new Node(head.data);
            currentClonedNode.next = clonedNode;
            nodeMapping.put(head, clonedNode);
            currentClonedNode = clonedNode;
            head = head.next;
        }
        // Step 2: Update the random pointers in the cloned list
        Node clonedHead = dummyNode.next; // Head of the cloned list
        while (currentOriginalNode != null) {
            if (currentOriginalNode.random != null) {
                clonedHead.random = nodeMapping.get(currentOriginalNode.random);
            }
            clonedHead = clonedHead.next;
            currentOriginalNode = currentOriginalNode.next;
        }
        return dummyNode.next;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data + " " + curr.random.data);
            curr = curr.next;
        }
    }
}
