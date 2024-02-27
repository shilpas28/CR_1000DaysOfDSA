//Leetcode
//543. Diameter of Binary Tree (Using Global Variable)
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class DiameterOfBinaryTree_2 {

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
        maxDepth(root);
        return res;
    }

    // global variable
    static int res = 0;

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);
            res = Math.max(res, lh + rh);
            return 1 + Math.max(lh, rh);
        }
    }

}
