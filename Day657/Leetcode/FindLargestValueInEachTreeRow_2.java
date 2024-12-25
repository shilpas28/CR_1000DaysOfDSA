//Leetcode
//515. Find Largest Value in Each Tree Row - using BFS
//Time complexity: O(N) - Each node is processed once, and the maximum value at each level is determined in constant time. 
//So, the overall time taken is linear with respect to the number of nodes.
//Space complexity: O(N) - In the worst case, the queue can hold all leaf nodes. In a balanced binary tree, the last level 
//can have N/2 nodes. Thus, the space complexity is linear.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow_2 {

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
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(largestValues(root));
    }

    public static List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int curr_level_size = queue.size();
            int max_val = Integer.MIN_VALUE;

            for (int i = 0; i < curr_level_size; i++) {
                TreeNode node = queue.poll();
                max_val = Math.max(max_val, node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(max_val);
        }
        return result;
    }
}
