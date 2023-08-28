//GFG
//Remove duplicate element from sorted Linked List
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

public class RemoveDuplicateElementFromSortedLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        Node res = removeDuplicates(head);
        Node currNode = res;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    // Function to remove duplicates from sorted linked list.
    static Node removeDuplicates(Node head) {
        // Your code here
        Node ans = new Node(-1);
        Node ansptr = ans;
        while (head != null) {
            if (head.data != ansptr.data) {
                ansptr.next = head;
                ansptr = ansptr.next;
            }
            head = head.next;
        }
        ansptr.next = null;
        return ans.next;
    }
}
