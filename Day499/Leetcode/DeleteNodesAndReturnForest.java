//Leetcode
//1110. Delete Nodes And Return Forest - Recursion
//Time complexity: O(n), since we go through each node exactly once
//Space complexity: O(n), since we use recursion (function call stack) and hashmap res

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeleteNodesAndReturnForest {

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
        Map<Integer, TreeNode> res = new HashMap<>();
        Set<Integer> to_delete_set = new HashSet<>();
        for (int val : to_delete)
            to_delete_set.add(val);

        res.put(root.val, root);
        recursion(null, root, false, res, to_delete_set);
        return new ArrayList<>(res.values());
    }

    static void recursion(TreeNode parent, TreeNode cur_node, boolean isleft, Map<Integer, TreeNode> res,
            Set<Integer> to_delete_set) {

        if (cur_node == null)
            return;
        recursion(cur_node, cur_node.left, true, res, to_delete_set);
        recursion(cur_node, cur_node.right, false, res, to_delete_set);

        if (to_delete_set.contains(cur_node.val)) {
            res.remove(cur_node.val);

            if (parent != null) {
                if (isleft)
                    parent.left = null;
                else
                    parent.right = null;
            }

            if (cur_node.left != null)
                res.put(cur_node.left.val, cur_node.left);
            if (cur_node.right != null)
                res.put(cur_node.right.val, cur_node.right);
        }
    }

}
