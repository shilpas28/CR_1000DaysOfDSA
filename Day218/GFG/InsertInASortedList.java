//GFG
//Insert in a Sorted List
//Time complexity: O(N)
//Space complexity: O(1)

package GFG; 

public class InsertInASortedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        // 25->36->47->58->69->80
        Node head = new Node(25);
        head.next = new Node(36);
        head.next.next = new Node(47);
        head.next.next.next = new Node(58);
        head.next.next.next.next = new Node(69);
        head.next.next.next.next.next = new Node(80);
        int key = 19;
        Node res = sortedInsert(head, key);
        printList(res);
    }

    // sortedInsert method should return the head of the modified linked list.
    static Node sortedInsert(Node head1, int key) {
        // Add your code here.
        Node x = new Node(key);
        if (head1.data >= key) {
            x.next = head1;
            return x;
        }

        Node node = head1;
        while (node.next != null) {
            if (node.data < key && node.next.data >= key) {
                x.next = node.next;
                node.next = x;
                return head1;
            }
            node = node.next;
        }
        node.next = x;

        return head1;
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
