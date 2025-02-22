//Leetcode
//1028. Recover a Tree From Preorder Traversal - Optimized Iterative Approach with Stack (Single Pass)
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.Stack;

public class RecoverATreeFromPreorderTraversal_3 {

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

    public static TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;

        while (index < traversal.length()) {
            // Count the number of dashes
            int depth = 0;
            while (index < traversal.length() && traversal.charAt(index) == '-') {
                depth++;
                index++;
            }
            // Extract the node value
            int value = 0;
            while (index < traversal.length() &&
                    Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }
            // Create the current node
            TreeNode node = new TreeNode(value);
            // Adjust the stack to the correct depth
            while (stack.size() > depth) {
                stack.pop();
            }
            // Attach the node to the parent
            if (!stack.empty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            // Push the current node onto the stack
            stack.push(node);
        }
        // The root is the first node in the stack
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }

    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
