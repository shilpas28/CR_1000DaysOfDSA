//Leetcode
//1457. Pseudo-Palindromic Paths in a Binary Tree
//Time complexity: O(N) 
//Space complexity: O(N)

package Leetcode;

public class PseudoPalindromicPathsInABinaryTree_2 {

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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(root));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        return countPseudoPalindromicPaths(root, 0);
    }

    static int countPseudoPalindromicPaths(TreeNode node, int path) {
        if (node == null) {
            return 0;
        }

        path ^= (1 << node.val);
        if (node.left == null && node.right == null) {
            return (path & (path - 1)) == 0 ? 1 : 0;
        }

        return countPseudoPalindromicPaths(node.left, path) + countPseudoPalindromicPaths(node.right, path);
    }
}
