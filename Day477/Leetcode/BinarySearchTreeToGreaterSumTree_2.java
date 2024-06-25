//Leetcode
//1038. Binary Search Tree to Greater Sum Tree - Using a sum TreeNode (more safety) instead of an instance variable.
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

public class BinarySearchTreeToGreaterSumTree_2 {

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
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        TreeNode res = bstToGst(root);
        printInorder(res);
    }

    public static TreeNode bstToGst(TreeNode root) {
        reversedInorder(root, 0);
        return root;
    }

    static int reversedInorder(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        } // base case.
        node.val += reversedInorder(node.right, sum); // recurse to right subtree.
        return reversedInorder(node.left, node.val); // recurse to left subtree.
    }

    static void printInorder(TreeNode res) {
        if (res == null)
            return;
        printInorder(res.left);
        System.out.print(res.val + " ");
        printInorder(res.right);
    }
}
