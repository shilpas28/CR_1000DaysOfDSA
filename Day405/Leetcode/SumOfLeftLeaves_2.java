//Leetcode
//404. Sum of Left Leaves - Iterative solution
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves_2 {

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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0) {
            root = q.poll();
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null)
                    sum += root.left.val;
                else
                    q.add(root.left);
            }
            if (root.right != null)
                q.add(root.right);
        }
        return sum;
    }
}
