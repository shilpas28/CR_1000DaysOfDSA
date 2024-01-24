//Leetcode
//1457. Pseudo-Palindromic Paths in a Binary Tree
//Time complexity: O(N) 
//Space complexity: O(N)

package Leetcode;

import java.util.Stack;

import javafx.util.Pair;

public class PseudoPalindromicPathsInABinaryTree {

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
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(root));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {

        int count = 0, path = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            path = p.getValue();

            if (node != null) {
                path = path ^ (1 << node.val);

                if (node.left == null && node.right == null) {
                    if ((path & (path - 1)) == 0) {
                        ++count;
                    }
                } else {
                    stack.push(new Pair<>(node.right, path));
                    stack.push(new Pair<>(node.left, path));
                }
            }
        }
        return count;
    }
}
