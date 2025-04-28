//GFG
//Maximum sum of Non-adjacent nodes
//Time complexity: O(N)
//Space complexity: O(N)

public class MaximumSumOfNonAdjacentNodes {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        System.out.println(getMaxSum(head));
    }

    // Function to return the maximum sum of non-adjacent nodes.
    public static int getMaxSum(Node root) {
        // code here
        int[] both = dfs(root);
        return Math.max(both[0], both[1]);
    }

    static int[] dfs(Node root) {
        if (root == null)
            return new int[] { 0, 0 };
        int[] left = dfs(root.left), right = dfs(root.right);
        int include = root.data + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] { include, exclude };
    }
}
