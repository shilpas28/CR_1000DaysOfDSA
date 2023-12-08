//Leetcode
//606. Construct String from Binary Tree
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructStringFromBinaryTree_2 {

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
        root.left.left = new TreeNode(4);
        System.out.println(tree2str(root));
    }

    public static String tree2str(TreeNode root) {
        if (root == null)
            return "";
        TreeNode dummy = new TreeNode(0);
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node == dummy) {
                sb.append(')');
                continue;
            }
            sb.append('(').append(node.val);
            s.push(dummy);
            if (node.left == null && node.right != null)
                sb.append("()");
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
        return sb.substring(1, sb.length() - 1);
    }
}
