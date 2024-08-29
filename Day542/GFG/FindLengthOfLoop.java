//GFG
//Find length of Loop
//Time complexity: O(N)
//Space complexity: O(1)

public class FindLengthOfLoop {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(25);
        head.next = new Node(14);
        head.next.next = new Node(19);
        head.next.next.next = new Node(33);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(21);
        head.next.next.next.next.next.next = new Node(39);
        head.next.next.next.next.next.next.next = new Node(90);
        head.next.next.next.next.next.next.next.next = new Node(58);
        head.next.next.next.next.next.next.next.next.next = new Node(45);
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;
        System.out.println(countNodesinLoop(head));
    }

    // Function to find the length of a loop in the linked list.
    public static int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return 0;
        int ans = 0;
        Node temp = slow.next;
        while (temp != slow) {
            temp = temp.next;
            ans++;
        }
        return ans + 1;
    }
}
