//Leetcode
//1372. Longest ZigZag Path in a Binary Tree
//Time complexity: O(N)
//Space complexity: O(h) where h is the height of the tree

package Leetcode;

public class LongestZigZagPathInABinaryTree {

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
        TreeNode root = new TreeNode(1);
        // root.right = new TreeNode(1);
        // root.right.left = new TreeNode(1);
        // root.right.right = new TreeNode(1);
        // root.right.right.left = new TreeNode(1);
        // root.right.right.right = new TreeNode(1);
        // root.right.right.left.right = new TreeNode(1);
        // root.right.right.left.right.right = new TreeNode(1);
        System.out.println(longestZigZag(root));
    }

    static int maxStep = 0;

    public static int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxStep;
    }

    private static void dfs(TreeNode root, boolean isLeft, int step) {
        if (root == null)
            return;
        maxStep = Math.max(maxStep, step); // update max step sofar
        if (isLeft) {
            dfs(root.left, false, step + 1); // keep going from root to left
            dfs(root.right, true, 1); // restart going from root to right
        } else {
            dfs(root.right, true, step + 1); // keep going from root to right
            dfs(root.left, false, 1); // restart going from root to left
        }
    }
}
