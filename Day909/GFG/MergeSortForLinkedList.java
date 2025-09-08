//GFG
//Merge Sort for Linked List
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class MergeSortForLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(40);
        head.next = new Node(20);
        head.next.next = new Node(60);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(30);
        Node res = mergeSort(head);
        printList(res);
    }

    public static Node mergeSort(Node head) {
        // code here
        if (head == null || head.next == null)
            return head;

        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return merge(left, right);
    }

    static Node findMid(Node head) {
        Node slow = head, fast = head.next; // start fast ahead
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        // Attach remaining nodes
        tail.next = (left != null) ? left : right;
        return dummy.next;
    }

    static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data);
            if (head.next != null)
                System.out.print("->");

            head = head.next;
        }
    }
}
