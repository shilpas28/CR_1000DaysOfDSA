//Leetcode
//1261. Find Elements in a Contaminated Binary Tree - Tree Traversal (BFS)
//Time complexity: O(N) for Find Elements, O(1) for find
//Space complexity: O(N)

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindElementsInAContaminatedBinaryTree_2 {

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
            bfs(root);
        }

        public boolean find(int target) {
            return seen.contains(target);
        }

        private void bfs(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            root.val = 0;
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.remove();
                // visit currentNode by adding its recovered value to the set
                seen.add(currentNode.val);
                if (currentNode.left != null) {
                    currentNode.left.val = currentNode.val * 2 + 1;
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    currentNode.right.val = currentNode.val * 2 + 2;
                    queue.add(currentNode.right);
                }
            }
        }
    }
}
