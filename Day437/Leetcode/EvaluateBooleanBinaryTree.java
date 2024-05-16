//Leetcode
//2331. Evaluate Boolean Binary Tree
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class EvaluateBooleanBinaryTree {

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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(evaluateTree(root));
    }

    public static boolean evaluateTree(TreeNode root) {
        if (root.val == 0)
            return false;
        if (root.val == 1)
            return true;
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2)
            return left | right;
        else
            return left & right;
    }
}
