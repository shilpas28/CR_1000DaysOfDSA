//Leetcode
//623. Add One Row to Tree - BFS, find the d-1th row and add new children to each of them
//Time complexity:
//Space complexity:

import java.util.LinkedList;

public class AddOneRowToTree {

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
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        int val = 1, depth = 2;
        addOneRow(root, val, depth);
        printPreorder(root);
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < depth - 2; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode t = queue.poll();
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
            }
        }
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            TreeNode tmp = t.left;
            t.left = new TreeNode(val);
            t.left.left = tmp;
            tmp = t.right;
            t.right = new TreeNode(val);
            t.right.right = tmp;
        }
        return root;
    }

    static void printPreorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
