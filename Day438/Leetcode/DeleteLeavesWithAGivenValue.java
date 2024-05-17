//Leetcode
//1325. Delete Leaves With a Given Value
//Time complexity: O(N)
//Space complexity: O(H) -> where H is height of tree

package Leetcode;

public class DeleteLeavesWithAGivenValue {

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        int target = 2;
        TreeNode res = removeLeafNodes(root, target);
        printInorder(res);
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            // If the current node is null, return null
            return null;
        }
        // Recursively process the left subtree
        root.left = removeLeafNodes(root.left, target);
        // Recursively process the right subtree
        root.right = removeLeafNodes(root.right, target);
        // Check if the current node is a leaf node with the target value
        if (root.left == null && root.right == null && root.val == target) {
            // If true, return null to remove this node
            return null;
        }
        // If the current node is not a target leaf node, return the current node
        return root;
    }

    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        // First recur on left subtree
        printInorder(root.left);
        // Now deal with the node
        System.out.print(root.val + " ");
        // Then recur on right subtree
        printInorder(root.right);
    }
}
