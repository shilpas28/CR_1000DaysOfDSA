//Leetcode
//145. Binary Tree Postorder Traversal Traversal - using Recursion
//Time complexity: O(N) Because We are traversing N nodes and every node is visited exactly once.
//Space complexity: O(N) Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_2 {

    static public class TreeNode {
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
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        postOrderTrav(root, postOrder);
        return postOrder;
    }

    static void postOrderTrav(TreeNode curr, List<Integer> postOrder) {
        if (curr == null)
            return;
        postOrderTrav(curr.left, postOrder);
        postOrderTrav(curr.right, postOrder);
        postOrder.add(curr.val);
    }
}
