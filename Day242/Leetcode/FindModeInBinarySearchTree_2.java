//leetcode
//501. Find Mode in Binary Search Tree
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindModeInBinarySearchTree_2 {

    // Definition for a binary tree node.
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
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(findMode(root)));
    }

    static Integer prev = null;
    static int count = 1;
    static int max = 0;

    public static int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i)
            res[i] = list.get(i);
        return res;
    }

    static void traverse(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
}
