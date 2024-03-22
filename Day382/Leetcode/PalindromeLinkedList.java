//Leetcode - Brute force method
//234. Palindrome Linked List
//Time complexity: O(N) - Iterating through the list to store elements in the array.
//Space complexity: O(N) - Using an array to store list elements for further computations.

package Leetcode;

import java.util.ArrayList;

public class PalindromeLinkedList {

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
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < arr.size() / 2; i++)
            if (arr.get(i) != arr.get(arr.size() - i - 1))
                return false;
        return true;
    }
}
