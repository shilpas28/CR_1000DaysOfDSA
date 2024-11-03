//GFG
//Is Linked List Length Even?
//Time complexity: O(N)
//Space complexity: O(1)

public class IsLinkedListLengthEven {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(52);
        head.next.next = new Node(10);
        head.next.next.next = new Node(47);
        head.next.next.next.next = new Node(95);
        head.next.next.next.next.next = new Node(0);
        System.out.println(isLengthEven(head));
    }

    public static boolean isLengthEven(Node head) {
        // code here
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count % 2 == 0;
    }
}
