//Leetcode - Optimal method
//234. Palindrome Linked List
//Time complexity: O(N/2)+O(N/2)+O(N/2) - O(N/2) for finding the middle element, reversing the list from the middle element, 
//and traversing again to find palindrome respectively.
//Space complexity: O(1) - No extra data structures are used.

package Leetcode;

public class PalindromeLinkedList_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(root));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;

        while (slow != null) {
            if (dummy.val != slow.val)
                return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }

    static ListNode reverse(ListNode ptr) {
        ListNode pre = null;
        ListNode nex = null;
        while (ptr != null) {
            nex = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = nex;
        }
        return pre;
    }
}
