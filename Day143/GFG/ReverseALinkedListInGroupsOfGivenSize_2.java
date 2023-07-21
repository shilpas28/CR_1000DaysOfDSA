//GFG
//Reverse a Linked List in groups of given size - Iterative approach
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class ReverseALinkedListInGroupsOfGivenSize_2 {
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
        Node nn = node;
        Node ans = new Node(-1);
        Node ansPtr = ans;
        while (nn != null) {
            Node start = nn;
            Node end = nn;
            int cnt = k;
            while (end != null && cnt != 1) {
                end = end.next;
                cnt--;
            }
            if (end != null) {
                nn = end.next;
                end.next = null;
            } else {
                nn = null;
            }
            ansPtr.next = reverseList(start);
            ansPtr = start;
        }
        return ans.next;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node next = null;
        Node ptr = head;
        while (ptr != null) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        return prev;
    }
}
