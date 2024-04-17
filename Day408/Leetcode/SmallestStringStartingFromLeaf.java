//Leetcode
//988. Smallest String Starting From Leaf
//Time complexity:
//Space complexity:

package Leetcode;

public class SmallestStringStartingFromLeaf {

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
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(smallestFromLeaf(root));
    }

    static String res = null;

    public static String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    static void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.insert(0, (char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            if (res == null || res.compareTo(sb.toString()) > 0)
                res = sb.toString();

        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(0);
    }
}
