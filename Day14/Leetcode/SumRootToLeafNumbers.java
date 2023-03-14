//Leetcode
//129. Sum Root to Leaf Numbers
//Time complexity: O(N)
//Space complexity: O(h) where he is height of recursive stack

package Leetcode;

public class SumRootToLeafNumbers {

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

        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(9);
        head.right = new TreeNode(0);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(1);
        System.out.println(sumNumbers(head));
    }

    public static int sumNumbers(TreeNode root) {
        return sumNodes(root, 0);
    }

    public static int sumNodes(TreeNode root, int currentSum) {
        if (root == null) return 0;
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) return currentSum;
        int leftSum = sumNodes(root.left, currentSum);
        int rightSum = sumNodes(root.right, currentSum);
        return leftSum + rightSum;
      }
}
