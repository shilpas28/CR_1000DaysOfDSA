//Leetcode
//1123. Lowest Common Ancestor of Deepest Leaves 
//Time complexity: O(N)
//Space complexity: O(H)

import java.util.HashMap;

public class LowestCommonAncestorOfDeepestLeaves_2 {

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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode res = lcaDeepestLeaves(root);
        inOrderTraversal(res);
    }

    static HashMap<TreeNode, Integer> heights = new HashMap<TreeNode, Integer>();

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null || height(root.right) == height(root.left))
            return root;
        return lcaDeepestLeaves(height(root.left) > height(root.right) ? root.left : root.right);
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        if (heights.containsKey(root))
            return heights.get(root);
        heights.put(root, 1 + Math.max(height(root.left), height(root.right)));
        return heights.get(root);
    }

    static void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }
}
