//GFG
//Maximum path sum
//Time complexity: O(N)
//Space complexity: O(H)

public class MaximumPathSum {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        System.out.println(findMaxSum(root));
    }

    static int findMaxSum(Node root) {
        // code here
        int[] maxi = { Integer.MIN_VALUE };
        findMaxPathSum(root, maxi);
        return maxi[0];
    }

    static int findMaxPathSum(Node root, int[] maxi) {

        if (root == null) {
            return 0;
        }

        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.data);

        return Math.max(leftMaxPath, rightMaxPath) + root.data;
    }
}
