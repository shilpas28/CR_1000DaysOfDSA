//Leetcode
//100. Same Tree
//Time complexity: O(N) - We are doing a tree traversal.
//Space complexity: O(N) - Space is needed for the recursion stack. In the worst case (skewed tree),space complexity can be O(N).

package Leetcode;

public class SameTree {

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
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(isSameTree(root1, root2));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;

        return ((p.val == q.val) && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right));
    }
}
