//Leetcode
//979. Distribute Coins in Binary Tree
//Time complexity: O(N)
//Space complexity: O(H) for the recursive tree

package Leetcode;

public class DistributeCoinsInBinaryTree {

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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(distributeCoins(root));
    }

    static int res = 0;

    public static int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    static int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
