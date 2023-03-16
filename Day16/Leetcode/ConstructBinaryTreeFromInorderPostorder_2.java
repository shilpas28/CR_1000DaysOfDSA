//Leetcode
//106. Construct Binary Tree from Inorder and Postorder Traversal
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderPostorder_2 {
    
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
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(inorder, postorder);
        inorder(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    public static TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1, hm);
        TreeNode rightchild = buildTreePostIn(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

}
