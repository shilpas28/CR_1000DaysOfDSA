//Leetcode - using BFS/Iterative solution 
//101. Symmetric Tree - Iterative solution
//Time complexity:
//Space complexity: 

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_1 {

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
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (q.isEmpty() == false) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();

            if (l == null && r == null)
                continue;
            if (l == null || r == null || l.val != r.val)
                return false;

            q.offer(l.left);
            q.offer(r.right);
            q.offer(l.right);
            q.offer(r.left);
        }
        return true;
    }

}
