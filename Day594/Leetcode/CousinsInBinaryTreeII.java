//Leetcode
//2641. Cousins in Binary Tree II - DFS
//Time complexity: O(n)
//Space complexity: O(h), where n = # of nodes, h = height of the tree

import java.util.ArrayList;
import java.util.List;

public class CousinsInBinaryTreeII {

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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.right = new TreeNode(7);
        TreeNode res = replaceValueInTree(root);
        printInorder(res);
    }

    public static TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        dfs(root, 0, levelSum);
        dfs2(root, 0, levelSum);
        return root;
    }

    static void dfs(TreeNode n, int depth, List<Integer> levelSum) {
        if (n != null) {
            if (depth == levelSum.size()) {
                levelSum.add(0);
            }
            levelSum.set(depth, levelSum.get(depth) + n.val);
            dfs(n.left, depth + 1, levelSum);
            dfs(n.right, depth + 1, levelSum);
        }
    }

    static void dfs2(TreeNode n, int depth, List<Integer> levelSum) {
        if (n != null) {
            n.val = levelSum.get(depth) - n.val;
            if (n.left != null && n.right != null) {
                int siblingsSum = n.left.val + n.right.val;
                n.left.val = n.right.val = siblingsSum;
            }
            dfs2(n.left, depth + 1, levelSum);
            dfs2(n.right, depth + 1, levelSum);
        }
    }

    static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
