//Leetcode
//129. Sum Root to Leaf Numbers - Iterative Post-Order Traversal
//Time complexity: O(N)
//Space complexity: O(H)

package Leetcode;

import java.util.Stack;

public class SumRootToLeafNumbers_2 {

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
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int curVal = 0;
        int sum = 0;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                curVal = curVal * 10 + cur.val;
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }

            if (cur.right == null && cur.left == null) {
                sum += curVal;
            }
            pre = stack.pop();
            curVal /= 10;
            cur = null;
        }
        return sum;
    }
}
