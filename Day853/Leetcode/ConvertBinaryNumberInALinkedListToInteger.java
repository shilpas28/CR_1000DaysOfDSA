//Leetcode
//1290. Convert Binary Number in a Linked List to Integer - Using ArrayList
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;

public class ConvertBinaryNumberInALinkedListToInteger {

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
        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int p = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int pow = (1 << p); // Finding 2 to the power p
            res += (pow * list.get(i));
            p++;
        }

        return res;
    }
}
