//Leetcode
//1028. Recover a Tree From Preorder Traversal - Brute Force (Recursive with String Manipulation)
//Time complexity: O(n)
//Space complexity: O(n)

public class RecoverATreeFromPreorderTraversal {

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
        String traversal = "1-2--3--4-5--6--7";
        TreeNode res = recoverFromPreorder(traversal);
        printInorder(res);
    }

    static int index = 0;

    public static TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return helper(traversal, 0);
    }

    static TreeNode helper(String traversal, int depth) {
        if (index >= traversal.length())
            return null;
        // Count the number of dashes
        int dashCount = 0;
        while ((index + dashCount) < traversal.length() &&
                traversal.charAt(index + dashCount) == '-') {
            dashCount++;
        }
        // If the number of dashes doesn't match the current depth, return null
        if (dashCount != depth)
            return null;
        // Move index past the dashes
        index += dashCount;
        // Extract the node value
        int value = 0;
        while (index < traversal.length() &&
                Character.isDigit(traversal.charAt(index))) {
            value = value * 10 + (traversal.charAt(index++) - '0');
        }
        // Create the current node
        TreeNode node = new TreeNode(value);
        // Recursively build the left and right subtrees
        node.left = helper(traversal, depth + 1);
        node.right = helper(traversal, depth + 1);
        return node;
    }

    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
