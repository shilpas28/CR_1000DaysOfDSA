//Leetcode
//515. Find Largest Value in Each Tree Row - using DFS
//Time complexity: O(N) - We visit each node exactly once, so the time complexity is O(N), where N is the number of nodes 
//in the binary tree.
//Space complexity: O(N) - In the worst case, the queue can contain all the nodes of a level, which is O(N). 

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

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
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    static void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) {
            return;
        }
        // expand list size
        if (d == res.size()) {
            res.add(root.val);
        } else {
            // or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }
}
