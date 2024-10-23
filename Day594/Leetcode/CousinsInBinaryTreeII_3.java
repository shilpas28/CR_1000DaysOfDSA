//Leetcode
//2641. Cousins in Binary Tree II - BFS Version2
//Time complexity: O(n)
//Space complexity: O(w), where n = # of nodes, w = the max # of the nodes among all levels of the tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinsInBinaryTreeII_3 {

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
        root.val = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<TreeNode> parents = new ArrayList<>(q);
            int nextLevelSum = 0;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode n = q.poll();
                for (TreeNode kid : new TreeNode[] { n.left, n.right }) {
                    if (kid != null) {
                        q.offer(kid);
                        nextLevelSum += kid.val;
                    }
                }
            }
            for (TreeNode n : parents) {
                int replacedVal = nextLevelSum;
                for (TreeNode kid : new TreeNode[] { n.left, n.right }) {
                    if (kid != null) {
                        replacedVal -= kid.val;
                    }
                }
                for (TreeNode kid : new TreeNode[] { n.left, n.right }) {
                    if (kid != null) {
                        kid.val = replacedVal;
                    }
                }
            }
        }
        return root;
    }

    static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
