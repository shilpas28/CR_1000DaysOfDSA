//Leetcode
//1367. Linked List in Binary Tree - KMP Search
//Time complexity: O(m+n), where n is size of binary tree, m is size of linked list
//Space complexity: O(h+m), h is height of the binary tree

import java.util.ArrayList;
import java.util.List;

public class LinkedListInBinaryTree_2 {

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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        System.out.println(isSubPath(head, root));
    }

    static int[] needle, lps;

    public static boolean isSubPath(ListNode head, TreeNode root) {
        needle = convertLinkedListToArray(head);
        lps = computeKMPTable(needle);
        return kmpSearch(root, 0);
    }

    static boolean kmpSearch(TreeNode i, int j) {
        if (j == needle.length)
            return true;
        if (i == null)
            return false;
        while (j > 0 && i.val != needle[j])
            j = lps[j - 1];
        if (i.val == needle[j])
            j++;
        return kmpSearch(i.left, j) || kmpSearch(i.right, j);
    }

    static int[] computeKMPTable(int[] pattern) {
        int n = pattern.length;
        int[] lps = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && pattern[i] != pattern[j])
                j = lps[j - 1];
            if (pattern[i] == pattern[j])
                lps[i] = ++j;
        }
        return lps;
    }

    static int[] convertLinkedListToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }
}
