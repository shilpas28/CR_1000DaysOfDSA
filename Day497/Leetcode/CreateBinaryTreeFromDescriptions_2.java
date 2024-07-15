//Leetcode
//2196. Create Binary Tree From Descriptions - BFS
//Time complexity: O(V + E), where V = # of nodes, E = # of edges
//Space complexity: O(V + E), where V = # of nodes, E = # of edges

package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions_2 {

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
        Set<Integer> kids = new HashSet<>(), parents = new HashSet<>();
        Map<Integer, List<int[]>> parentToKids = new HashMap<>();
        for (int[] d : descriptions) {
            int parent = d[0], kid = d[1];
            parents.add(parent);
            kids.add(kid);
            parentToKids.computeIfAbsent(parent, l -> new ArrayList<>()).add(new int[] { kid, d[2] });
        }
        parents.removeAll(kids);
        TreeNode root = new TreeNode(parents.iterator().next());
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            TreeNode parent = dq.poll();
            for (int[] kidInfo : parentToKids.getOrDefault(parent.val, Arrays.asList())) {
                int kid = kidInfo[0], left = kidInfo[1];
                dq.offer(new TreeNode(kid));
                if (left == 1) {
                    parent.left = dq.peekLast();
                } else {
                    parent.right = dq.peekLast();
                }
            }
        }
        return root;
    }

    static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
