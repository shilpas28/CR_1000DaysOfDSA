//Leetcode
//2583. Kth Largest Sum in a Binary Tree - Using DFS
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargestSumInABinaryTree {

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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        int k = 2;
        System.out.println(kthLargestLevelSum(root, k));
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {

        long[] arr = new long[100000];
        dfs(root, arr, 0);
        // System.out.println("level="+level);

        if ((level + 1) < k)
            return -1;

        List<Long> list = new ArrayList<>();
        for (int i = 0; i <= level; i++)
            // System.out.print(" "+arr[i]);
            list.add(arr[i]);

        Collections.sort(list, Collections.reverseOrder());
        return list.get(k - 1);
    }

    static int level;

    static void dfs(TreeNode root, long[] arr, int idx) {

        if (root == null)
            return;

        dfs(root.left, arr, idx + 1);
        dfs(root.right, arr, idx + 1);
        // System.out.println(" "+root.val+" : "+idx);
        arr[idx] += root.val;
        level = Math.max(level, idx);
    }
}
