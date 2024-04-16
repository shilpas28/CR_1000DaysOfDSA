//Leetcode
//623. Add One Row to Tree - DFS without helper function
//Time complexity:
//Space complexity:

public class AddOneRowToTree_3 {

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
        if (depth < 2) {
            TreeNode newroot = new TreeNode(val);
            if (depth == 0)
                newroot.right = root;
            else
                newroot.left = root;
            return newroot;
        }
        if (root == null)
            return null;
        root.left = addOneRow(root.left, val, depth == 2 ? 1 : depth - 1);
        root.right = addOneRow(root.right, val, depth == 2 ? 0 : depth - 1);
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
