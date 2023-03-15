//958. Check Completeness of a Binary Tree
//Leetcode - using Level order traversal
//Time complexity:
//Space complexity:

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {

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
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(6);

        System.out.println(isCompleteTree(head));
    }

    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null)
                flag = true;
            else {
                if (flag)
                    return false;
                q.offer(temp.left);
                q.offer(temp.right);
            }
        }
        return true;
    }

}
