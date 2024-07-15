//Leetcode
//2196. Create Binary Tree From Descriptions - HashMap
//Time complexity: O(V + E), where V = # of nodes, E = # of edges
//Space complexity: O(V + E), where V = # of nodes, E = # of edges

package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {

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
        int[][] descriptions = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
        TreeNode res = createBinaryTree(descriptions);
        printInorder(res);
    }

    static TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> kids = new HashSet<>();
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        for (int[] d : descriptions) {
            int parent = d[0], kid = d[1], left = d[2];
            valToNode.putIfAbsent(parent, new TreeNode(parent));
            valToNode.putIfAbsent(kid, new TreeNode(kid));
            kids.add(kid);
            if (left == 1) {
                valToNode.get(parent).left = valToNode.get(kid);
            } else {
                valToNode.get(parent).right = valToNode.get(kid);
            }
        }
        valToNode.keySet().removeAll(kids);
        return valToNode.values().iterator().next();
    }

    static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
