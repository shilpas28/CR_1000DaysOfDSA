//GFG
//Quick Sort on Linked List
//Time complexity: O(N^2)
//Space complexity: O(N)

public class QuickSortOnLinkedList {

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
        head.next = new Node(9);
        head.next.next = new Node(3);
        head.next.next.next = new Node(8);
        Node res = quickSort(head);
        printList(res);
    }

    public static Node quickSort(Node node) {
        // Your code here
        if (node == null || node.next == null)
            return node;
        Node left[] = new Node[1];
        Node right[] = new Node[1];
        partition(node, left, right);
        left[0] = quickSort(left[0]);
        right[0] = quickSort(right[0]);
        Node traversal = left[0];
        while (traversal != null && traversal.next != null)
            traversal = traversal.next;
        if (traversal != null)
            traversal.next = node;
        else
            left[0] = node;
        node.next = right[0];
        return left[0];
    }

    static void partition(Node pivot, Node left[], Node right[]) {
        Node temp = pivot.next;
        while (temp != null) {
            Node nxt = temp.next;
            if (temp.data <= pivot.data) {
                temp.next = left[0];
                left[0] = temp;
            } else {
                temp.next = right[0];
                right[0] = temp;
            }
            temp = nxt;
        }
    }

    static void printList(Node head) {
        Node currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
}
