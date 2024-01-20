//GFG
//Distribute candies in a binary tree
//Time complexity: O(N)
//Space complexity: O(height of the tree) 

package GFG;

public class DistributeCandiesInABinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(0);
        root.right = new Node(0);
        System.out.println(distributeCandy(root));
    }

    static int ans;

    public static int distributeCandy(Node root) {
        // code here
        ans = 0;
        solve(root);
        return ans;
    }

    static int solve(Node root) {
        if (root == null) {
            return 0;
        }
        int left_profit = solve(root.left);
        int right_profit = solve(root.right);
        ans += Math.abs(left_profit) + Math.abs(right_profit);
        return root.data + left_profit + right_profit - 1;
    }
}
