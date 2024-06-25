//Leetcode
//1038. Binary Search Tree to Greater Sum Tree - Using stack to pop out the nodes in reversed in order sequence.
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeToGreaterSumTree {

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
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) { // save right-most path of the current subtree
                stk.push(cur);
                cur = cur.right;
            }
            cur = stk.pop(); // pop out by reversed in-order.
            sum += cur.val; // update sum.
            cur.val = sum; // update node value.
            cur = cur.left; // move to left branch.
        }
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
