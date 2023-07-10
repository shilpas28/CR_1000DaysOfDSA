//Leetcode
//111. Minimum Depth of Binary Tree - DFS Solution 
//Time complexity:
//Space complexity:

package Leetcode;

public class MinimumDepthOfBinaryTree {

    public static class TreeNode {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (minLeft == 0 || minRight == 0) // To account for skewed trees
            return 1 + Math.max(minLeft, minRight);
        else
            return 1 + Math.min(minLeft, minRight);
    }
}
