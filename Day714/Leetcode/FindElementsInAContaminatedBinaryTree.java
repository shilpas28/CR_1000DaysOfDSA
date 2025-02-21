//Leetcode
//1261. Find Elements in a Contaminated Binary Tree - Tree Traversal (DFS)
//Time complexity: O(N) for Find Elements, O(1) for find
//Space complexity: O(N)

import java.util.HashSet;

public class FindElementsInAContaminatedBinaryTree {

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
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        FindElements findElements = new FindElements(root);
        System.out.println(findElements.find(1)); // return True
        System.out.println(findElements.find(3)); // return True
        System.out.println(findElements.find(5)); // return False
    }

    static class FindElements {

        HashSet<Integer> seen;

        public FindElements(TreeNode root) {
            seen = new HashSet<>();
            dfs(root, 0);
        }

        public boolean find(int target) {
            return seen.contains(target);
        }

        private void dfs(TreeNode currentNode, int currentValue) {
            if (currentNode == null)
                return;
            // visit current node by adding its value to seen
            seen.add(currentValue);
            dfs(currentNode.left, currentValue * 2 + 1);
            dfs(currentNode.right, currentValue * 2 + 2);
        }
    }

}
