//Leetcode
//2265. Count Nodes Equal to Average of Subtree
//Time complexity: O(N)
//Space complexity: O(H) where H is height of tree

package Leetcode;

public class CountNodesEqualToAverageOfSubtree_2 {

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

    static int result = 0;

    public static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == node.val) {
            result++;
        }

        return new int[] { sum, count };
    }
}
