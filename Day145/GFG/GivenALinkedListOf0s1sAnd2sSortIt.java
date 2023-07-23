//GFG
//Given a linked list of 0s, 1s and 2s, sort it
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class GivenALinkedListOf0s1sAnd2sSortIt {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);
        Node res = segregate(head);
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

    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        int cnt[] = new int[3];
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.data == 0)
                cnt[0]++;
            else if (curr.data == 1)
                cnt[1]++;
            else
                cnt[2]++;
        }
        Node curr = head;
        int idx = 0;
        while (curr != null) {
            if (cnt[idx] == 0)
                idx++;

            if (cnt[idx] != 0) {
                curr.data = idx;
                cnt[idx]--;
                curr = curr.next;
            }
        }
        return head;
    }
}
