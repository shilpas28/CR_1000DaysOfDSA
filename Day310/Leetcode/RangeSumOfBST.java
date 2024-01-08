//Leetcode
//938. Range Sum of BST - Using DFS 
//Time complexity: O(n), where n is the number of nodes in the tree. In the worst case, we may need to visit all nodes in the tree.
//Space complexity: O(h), where h is the height of the tree. This represents the maximum depth of the recursive call stack. In the 
//worst case, for an unbalanced tree, the space complexity can be O(n), but for a balanced tree, it is O(logn).

package Leetcode;

public class RangeSumOfBST {

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

        int low = 7, high = 15;
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, low, high));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int currentVal = (root.val >= low && root.val <= high) ? root.val : 0;
        int leftSum = rangeSumBST(root.left, low, high);
        int rightSum = rangeSumBST(root.right, low, high);

        return currentVal + leftSum + rightSum;
    }
}
