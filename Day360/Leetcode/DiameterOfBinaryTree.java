//Leetcode
//543. Diameter of Binary Tree
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class DiameterOfBinaryTree {

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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int d1 = heightOfBinaryTree(root.left) + heightOfBinaryTree(root.right);
        int d2 = diameterOfBinaryTree(root.left);
        int d3 = diameterOfBinaryTree(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }

    public static int heightOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        else
            return (1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)));
    }

}
