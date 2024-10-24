//Leetcode
//951. Flip Equivalent Binary Trees - Iterative DFS
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.Stack;

public class FlipEquivalentBinaryTrees_2 {

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
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right.left = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        System.out.println(flipEquiv(root1, root2));
    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stk1 = new Stack<>(), stk2 = new Stack<>();
        stk1.push(root1);
        stk2.push(root2);
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            TreeNode n1 = stk1.pop(), n2 = stk2.pop();
            if (n1 == null && n2 == null)
                continue;
            else if (n1 == null || n2 == null || n1.val != n2.val)
                return false;

            if (n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val)
                stk1.addAll(Arrays.asList(n1.left, n1.right));
            else
                stk1.addAll(Arrays.asList(n1.right, n1.left));

            stk2.addAll(Arrays.asList(n2.left, n2.right));
        }
        return stk1.isEmpty() && stk2.isEmpty();
    }
}
