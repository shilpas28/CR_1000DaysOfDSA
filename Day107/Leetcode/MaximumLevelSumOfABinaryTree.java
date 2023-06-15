//Leetcode
//1161. Maximum Level Sum of a Binary Tree
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {

    public static class TreeNode {
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
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right = new TreeNode(0);
        System.out.println(maxLevelSum(root));
    }

    public static int maxLevelSum(TreeNode root) {
        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        int curLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = curLevel;
            }
            curLevel++;
        }
        return maxLevel;
    }
}
