//Leetcode
//1290. Convert Binary Number in a Linked List to Integer - Using String 
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class ConvertBinaryNumberInALinkedListToInteger_2 {

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
        String s = "";
        while (head != null) {
            s = s + Integer.toString(head.val);
            head = head.next;
        }

        return Integer.parseInt(s, 2); // we can pass the radix also in which the number has to be converted
    }
}
