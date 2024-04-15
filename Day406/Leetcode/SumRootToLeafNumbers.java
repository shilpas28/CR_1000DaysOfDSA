//Leetcode
//129. Sum Root to Leaf Numbers - Recursive DFS Solution
//Time complexity: O(N)
//Space complexity: O(H)

package Leetcode;

public class SumRootToLeafNumbers {

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
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbersHelper(root, 0);
    }

    static int sumNumbersHelper(TreeNode node, int curVal) {
        if (node == null) {
            return 0;
        }

        curVal = curVal * 10 + node.val;
        if (node.left == null && node.right == null) {
            return curVal;
        }

        return sumNumbersHelper(node.left, curVal) + sumNumbersHelper(node.right, curVal);
    }
}
