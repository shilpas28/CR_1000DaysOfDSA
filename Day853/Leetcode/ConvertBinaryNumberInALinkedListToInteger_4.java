//Leetcode
//1290. Convert Binary Number in a Linked List to Integer - Bit Manipulation
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class ConvertBinaryNumberInALinkedListToInteger_4 {

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
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res = res << 1 | head.val; // res = res*2 + head.val;
            head = head.next;
        }

        return res;
    }
}
