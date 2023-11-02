//Leetcode
//2265. Count Nodes Equal to Average of Subtree
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class CountNodesEqualToAverageOfSubtree {

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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
        System.out.println(averageOfSubtree(root));
    }

    static int sum = 0;
    static int count = 0;
    static int level = 0;

    public static int averageOfSubtree(TreeNode root) {
        average(root);
        return level;
    }

    public static void average(TreeNode root) {
        if (root == null)
            return;

        preorder(root);
        if (sum / count == root.val)
            level++;

        sum = 0;
        count = 0;
        average(root.left);
        average(root.right);
    }

    public static void preorder(TreeNode root) {
        if (root == null)
            return;

        sum += root.val;
        count++;
        preorder(root.left);
        preorder(root.right);
    }
}
