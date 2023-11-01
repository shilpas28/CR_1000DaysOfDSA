//leetcode
//501. Find Mode in Binary Search Tree
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindModeInBinarySearchTree {

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

    static int maxCount = 1;

    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findMode(root, map);

        int[] result = new int[map.size()];
        int index = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) {
                result[index++] = key;
            }
        }

        return Arrays.copyOf(result, index);
    }

    static void findMode(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        } else if (map.containsKey(root.val)) {
            int count = map.get(root.val) + 1;
            map.put(root.val, count);
            maxCount = Math.max(maxCount, count);
        } else {
            map.put(root.val, 1);
        }

        findMode(root.left, map);
        findMode(root.right, map);
    }
}
