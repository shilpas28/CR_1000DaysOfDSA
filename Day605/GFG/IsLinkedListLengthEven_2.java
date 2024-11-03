//GFG
//Is Linked List Length Even? - USing slow and fast pointers
//Time complexity: O(N/2) 
//Space complexity: O(1)

public class IsLinkedListLengthEven_2 {

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
        // If length is 1 -->
        if (head.next == null)
            return false;

        Node fast = head.next;
        Node slow = head;
        // Move FAST pointer by two steps -->
        // Move SLOW pointer by one step -->
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // If FAST reaches null, it means length is ODD -->
        if (fast == null)
            return false;
        // If FAST is pointing to last node, it means length is EVEN -->
        return true;
    }
}
