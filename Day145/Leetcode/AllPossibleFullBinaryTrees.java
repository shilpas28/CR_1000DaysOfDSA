//Leetcode
//894. All Possible Full Binary Trees
//Time complexity: O(2^N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

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
        int n = 7;
        List<TreeNode> res = allPossibleFBT(n);
        for(TreeNode val:res){
            findFullNode(val);
            System.out.println();
        }
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        n = n - 1;
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public static void findFullNode(TreeNode root)
    {
        if (root != null)
        {
            findFullNode(root.left);
            if (root.left != null && root.right != null)
                System.out.print(root.val+" ");
            findFullNode(root.right);
        }
    }
}
