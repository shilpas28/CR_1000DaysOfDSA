//Leetcode
//1026. Maximum Difference Between Node and Ancestor
//Time complexity: O(N), where N is the number of nodes in the tree, as we visit each node once.
//Space complexity: O(H), where H is the height of the tree.

package Leetcode;

public class MaximumDifferenceBetweenNodeAndAncestor {

    // Definition for a binary tree node.
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
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(maxAncestorDiff(root));
    }

    static int diff = 0;

    public static int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        int min = root.val, max = root.val;
        diff(root, min, max);
        return diff;
    }

    static void diff(TreeNode root, int min, int max) {
        if (root == null)
            return;
        diff = Math.max(diff, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff(root.left, min, max);
        diff(root.right, min, max);
    }
}
