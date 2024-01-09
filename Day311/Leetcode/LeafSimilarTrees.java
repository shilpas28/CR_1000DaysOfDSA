//Leetcode
//872. Leaf-Similar Trees
//Time complexity: O(N+M) - The time complexity of the algorithm is determined by the depth-first search (DFS) function, which visits 
//every node in the binary tree exactly once. Therefore, the time complexity is O(N+M), where N is the number of nodes in the first tree 
//and M is the number of nodes in the second tree.
//Space complexity: O(H1+H2) - In the worst case, the depth of the recursion could be O(H1+H2), where H1 is the maximum height of the 
//first tree and H2 is the maximum height of the second tree, if the trees are highly skewed.

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

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
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        helper(list1, root1);
        helper(list2, root2);

        if (list1.equals(list2))
            return true;
        else
            return false;
    }

    static void helper(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        } else {
            helper(list, root.left);
            helper(list, root.right);
        }
    }

}
