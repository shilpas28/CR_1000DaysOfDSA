//Leetcode
//889. Construct Binary Tree from Preorder and Postorder Traversal - Optimized Recursion
//Time complexity: O(N)
//Space complexity: O(N) 

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_3 {

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
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };
        TreeNode res = constructFromPrePost(preorder, postorder);
        printInorder(res);
    }

    static int preIndex = 0;
    static int postIndex = 0;

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder);
    }

    // Helper function to recursively build the tree
    static TreeNode constructTree(int[] preorder, int[] postorder) {
        // Create a new node with the value at the current preorder index
        TreeNode root = new TreeNode(preorder[preIndex++]);
        // Recursively construct the left subtree if the root is not the last of
        // its subtree
        if (root.val != postorder[postIndex]) {
            root.left = constructTree(preorder, postorder);
        }
        // Recursively construct the right subtree if the root is still not the
        // last of its subtree
        if (root.val != postorder[postIndex]) {
            root.right = constructTree(preorder, postorder);
        }
        // Mark this node and its subtree as fully processed
        postIndex++;
        return root;
    }

    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
