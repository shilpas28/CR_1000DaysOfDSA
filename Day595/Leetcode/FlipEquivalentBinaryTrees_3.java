//Leetcode
//951. Flip Equivalent Binary Trees - Iterative BFS
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FlipEquivalentBinaryTrees_3 {

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
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll(), n2 = q2.poll();
            if (n1 == null || n2 == null) {
                if (n1 != n2)
                    return false;
                else
                    continue;
            }
            if (n1.val != n2.val)
                return false;

            if (n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val)
                q1.addAll(Arrays.asList(n1.left, n1.right));
            else
                q1.addAll(Arrays.asList(n1.right, n1.left));
            q2.addAll(Arrays.asList(n2.left, n2.right));
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
