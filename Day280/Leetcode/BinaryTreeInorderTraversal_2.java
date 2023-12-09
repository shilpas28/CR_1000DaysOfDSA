//Leetcode
//94. Binary Tree Inorder Traversal - Iterative solution 
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_2 {

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
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> output_list = new ArrayList<>();
        if (root == null)
            return output_list;
        TreeNode curr = root;
        while (curr != null || st.isEmpty() == false) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            output_list.add(curr.val);
            curr = curr.right;
        }
        return output_list;
    }
}
