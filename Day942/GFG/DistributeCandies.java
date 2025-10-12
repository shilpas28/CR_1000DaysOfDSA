//GFG
//Distribute Candies
//Time complexity: O(N)
//Space complexity: O(H)

public class DistributeCandies {

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
        Node root = new Node(5);
        root.left = new Node(0);
        root.right = new Node(0);
        root.right.left = new Node(0);
        root.right.right = new Node(0);
        System.out.println(distCandy(root));
    }

    static int ans;

    public static int distCandy(Node root) {
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
