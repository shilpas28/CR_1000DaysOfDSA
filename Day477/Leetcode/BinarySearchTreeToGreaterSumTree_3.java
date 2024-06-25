//Leetcode
//1038. Binary Search Tree to Greater Sum Tree - Using Morris algorithm
//Time complexity: O(n)
//Space complexity: O(1)

package Leetcode;

public class BinarySearchTreeToGreaterSumTree_3 {

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
        TreeNode cur = root;
        int sum = 0;
        while (cur != null) {
            if (cur.right != null) { // traverse right subtree.
                TreeNode leftMost = cur.right;
                while (leftMost.left != null && leftMost.left != cur) { // locate the left-most node of cur's right
                                                                        // subtree.
                    leftMost = leftMost.left;
                }
                if (leftMost.left == null) { // never visit the left-most node yet.
                    leftMost.left = cur; // construct a way back to cur.
                    cur = cur.right; // explore right.
                } else { // visited leftMost already, which implies now on way back.
                    leftMost.left = null; // cut off the fabricated link.
                    sum += cur.val; // update sum.
                    cur.val = sum; // update node value.
                    cur = cur.left; // continue on way back.
                }
            } else { // no right child: 1) cur is the right-most of unvisited nodes; 2) must traverse
                     // left.
                sum += cur.val; // update sum.
                cur.val = sum; // update node value.
                cur = cur.left; // continue on way back.
            }
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
