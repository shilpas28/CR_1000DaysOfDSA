//GFG
//Reverse a Linked List in groups of given size - Recursive approach
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class ReverseALinkedListInGroupsOfGivenSize {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        int K = 4;
        Node res = reverse(head, K);
        printList(res);
    }

    public static void printList(Node res) {
        Node currNode = res;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    public static Node reverse(Node node, int k) {
        // Your code here
        if (node == null)
            return null;
        Node prev = null;
        Node next = null;
        Node headptr = node;
        int cnt = k;
        while (headptr != null && cnt != 0) {
            next = headptr.next;
            headptr.next = prev;
            prev = headptr;
            headptr = next;
            cnt--;
        }
        node.next = reverse(headptr, k);
        return prev;
    }
}
