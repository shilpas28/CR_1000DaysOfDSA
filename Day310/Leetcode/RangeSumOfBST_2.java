//Leetcode
//938. Range Sum of BST - - Using BFS 
//Time complexity: O(N)
//Space complexity: O(N) for stack

package Leetcode;

import java.util.Stack;

public class RangeSumOfBST_2 {

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

        int low = 7, high = 15;
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, low, high));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        int sum = 0;
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            if (n == null)
                continue;
            if (n.val >= low && n.val <= high)
                sum += n.val;
            if (n.val > low)
                st.push(n.left);
            if (n.val < high)
                st.push(n.right);
        }
        return sum;
    }
}
