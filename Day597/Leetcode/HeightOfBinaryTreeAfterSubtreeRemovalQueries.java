//Leetcode
//2458. Height of Binary Tree After Subtree Removal Queries
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {

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
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);
        int[] queries = { 4 };
        System.out.println(Arrays.toString(treeQueries(root, queries)));
    }

    static Map<Integer, Integer> leftMap = new HashMap<>();
    static Map<Integer, Integer> rightMap = new HashMap<>();
    static Map<Integer, Integer> removed = new HashMap<>();

    public static int[] treeQueries(TreeNode root, int[] queries) {
        populateHeights(root, 0);
        calculateRemovedHeights(root, 0);

        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            output[i] = removed.get(queries[i]);
        }
        return output;
    }

    // height is the max tree height with this node removed
    static void calculateRemovedHeights(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        removed.put(node.val, height);
        // for each child, the height when removed is the max of the the height
        // following
        // the opposite child, or the passed-in height with this node removed
        calculateRemovedHeights(node.left, Math.max(height, rightMap.get(node.val)));
        calculateRemovedHeights(node.right, Math.max(height, leftMap.get(node.val)));
    }

    // populate the maps with the total height of the left and right subtree of
    // each node, and return the larger of the two values
    static int populateHeights(TreeNode node, int height) {
        if (node == null)
            return height - 1;

        leftMap.put(node.val, populateHeights(node.left, height + 1));
        rightMap.put(node.val, populateHeights(node.right, height + 1));

        return Math.max(leftMap.get(node.val), rightMap.get(node.val));
    }
}
