//GFG
//Palindrome Linked List
//Time complexity: O(N)
//Space complexity: O(1)

public class PalindromeLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(head));
    }

    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {
        // Your code here
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node curr = slow.next, nxt = null, prev = null;
        slow.next = null;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        while (prev != null) {
            if (prev.data != head.data)
                return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
