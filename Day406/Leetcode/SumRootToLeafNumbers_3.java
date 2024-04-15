//Leetcode
//129. Sum Root to Leaf Numbers - Iterative Pre-Order Traversal
//Time complexity:
//Space complexity:

package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import javafx.util.Pair;

public class SumRootToLeafNumbers_3 {
    
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
        if (root.left == null && root.right == null) {
            return root.val;
        }

        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, root.val));

        int sum = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            TreeNode node = cur.getKey();
            int num = cur.getValue();

            if (node.left == null && node.right == null) {
                sum += num;
                continue;
            }
			
			if (node.right != null) {
                stack.push(new Pair<>(node.right, num * 10 + node.right.val));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, num * 10 + node.left.val));
            }
        }
        return sum;
    }
}
