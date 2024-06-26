//Leetcode
//1382. Balance a Binary Search Tree - Sorted Array to BST
//Time complexity: O(N) 
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {

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
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode res = balanceBST(root);
        printInorder(res);
    }

    static List<TreeNode> sortedArr = new ArrayList<>();

    public static TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArr.size() - 1);
    }

    static void inorderTraverse(TreeNode root) {
        if (root == null)
            return;
        inorderTraverse(root.left);
        sortedArr.add(root);
        inorderTraverse(root.right);
    }

    static TreeNode sortedArrayToBST(int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }

    static void printInorder(TreeNode res) {
        if (res == null)
            return;
        printInorder(res.left);
        System.out.print(res.val + " ");
        printInorder(res.right);
    }

}
