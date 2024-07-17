//Leetcode
//1110. Delete Nodes And Return Forest - Iterative BFS
//Time complexity: O(n), since we go through each node exactly once
//Space complexity: O(n) since we use additional queue queue

package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DeleteNodesAndReturnForest_2 {

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
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] to_delete = { 3, 5 };
        System.out.println(delNodes(root, to_delete));
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return result;

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete)
            toDeleteSet.add(val);
            
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            if (curNode.left != null) {
                queue.offer(curNode.left);
                if (toDeleteSet.contains(curNode.left.val))
                    curNode.left = null;
            }

            if (curNode.right != null) {
                queue.offer(curNode.right);
                if (toDeleteSet.contains(curNode.right.val))
                    curNode.right = null;
            }

            if (toDeleteSet.contains(curNode.val)) {
                if (curNode.left != null)
                    result.add(curNode.left);
                if (curNode.right != null)
                    result.add(curNode.right);
            } else if (result.isEmpty())
                result.add(curNode);
        }
        return result;
    }

}
