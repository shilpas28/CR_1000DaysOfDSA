//GFG
//Reverse alternate nodes in Link List
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

public class ReverseAlternateNodesInLinkList {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        // 10->4->9->1->3->5->9->4
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.next = new Node(9);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(4);
        rearrange(head);
        printList(head);
    }

    static void rearrange(Node odd) {
        // add your code here
        if (odd.next == null)
            return;

        Node h1 = odd;
        Node h2 = odd.next;// need in reversing the list
        Node t1 = h1, t2 = h2;

        while (true) {
            t1.next = t1.next.next;
            t1 = t1.next;
            if (t2.next.next == null) {
                t1.next = null;
                break;
            }

            t2.next = t1.next;
            t2 = t2.next;
            if (t1.next.next == null) {
                t1.next = null;
                break;
            }
        }
        t2.next = null;
        t1.next = reverse(h2);
    }

    static Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node currNode = head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
