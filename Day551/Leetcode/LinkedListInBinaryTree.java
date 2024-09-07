//Leetcode
//1367. Linked List in Binary Tree - Brute force
//Time complexity: O(m * min(n, h)), where n is size of binary tree, m is size of linked list
//Space complexity: O(h), h is height of the binary tree

public class LinkedListInBinaryTree {

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

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    static boolean dfs(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}
