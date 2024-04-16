//Leetcode
//623. Add One Row to Tree - DFS, with helper function that knows the current depth of each recursion
//Time complexity:
//Space complexity:

public class AddOneRowToTree_2 {

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
        dfs(root, 1, val, depth);
        return root;
    }

    static void dfs(TreeNode root, int depth, int v, int d) {
        if (root == null)
            return;
        if (depth < d - 1) {
            dfs(root.left, depth + 1, v, d);
            dfs(root.right, depth + 1, v, d);
        } else {
            TreeNode tmp = root.left;
            root.left = new TreeNode(v);
            root.left.left = tmp;
            tmp = root.right;
            root.right = new TreeNode(v);
            root.right.right = tmp;
        }
    }

    static void printPreorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
