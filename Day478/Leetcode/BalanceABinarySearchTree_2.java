//Leetcode
//1382. Balance a Binary Search Tree - DSW algorithm 
//Time complexity: O(N)
//Space complexity: O(1)

public class BalanceABinarySearchTree_2 {

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
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode res = balanceBST(root);
        printInorder(res);
    }

    public static TreeNode balanceBST(TreeNode root) {
        TreeNode grand = new TreeNode(0);
        grand.right = root;
        int cnt = makeVine(grand);
        int m = (int) Math.pow(2, (int) (Math.log(cnt + 1) / Math.log(2))) - 1;
        compress(grand, cnt - m);
        for (m = m / 2; m > 0; m /= 2)
            compress(grand, m);
        return grand.right;
    }

    static int makeVine(TreeNode grand) {
        int cnt = 0;
        TreeNode n = grand.right;
        while (n != null) {
            if (n.left != null) {
                TreeNode old_n = n;
                n = n.left;
                old_n.left = n.right;
                n.right = old_n;
                grand.right = n;
            } else {
                ++cnt;
                grand = n;
                n = n.right;
            }
        }
        return cnt;
    }

    static void compress(TreeNode grand, int m) {
        TreeNode n = grand.right;
        while (m-- > 0) {
            TreeNode old_n = n;
            n = n.right;
            grand.right = n;
            old_n.right = n.left;
            n.left = old_n;
            grand = n;
            n = n.right;
        }
    }

    static void printInorder(TreeNode res) {
        if (res == null)
            return;
        printInorder(res.left);
        System.out.print(res.val + " ");
        printInorder(res.right);
    }

}
