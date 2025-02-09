//GFG
//Maximum path sum from any node
//Time complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly 
//once during the recursive traversal.
//Space complexity: O(1) as no additional space or data structures is created that is proportional to the input size of the tree. 
//O(H) Recursive Stack Auxiliary Space : The recursion stack space is determined by the maximum depth of the recursion, which is 
//the height of the binary tree denoted as H. In the balanced case it is log2N and in the worst case its N.

public class MaximumPathSumFromAnyNode {

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

    // Function to return maximum path sum from any node in a tree.
    static int findMaxSum(Node node) {
        // your code goes here
        // Initialize maxi to the
        // minimum possible integer value
        int[] maxi = { Integer.MIN_VALUE };
        // Call the recursive function to
        // find the maximum path sum
        findMaxPathSum(node, maxi);
        // Return the final maximum path sum
        return maxi[0];
    }

    // Recursive function to find the maximum path sum
    // for a given subtree rooted at 'root'
    // The variable 'maxi' is a reference parameter
    // updated to store the maximum path sum encountered
    static int findMaxPathSum(Node root, int[] maxi) {
        // Base case: If the current node is null, return 0
        if (root == null) {
            return 0;
        }
        // Calculate the maximum path sum
        // for the left and right subtrees
        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));
        // Update the overall maximum
        // path sum including the current node
        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.data);
        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current node
        return Math.max(leftMaxPath, rightMaxPath) + root.data;
    }
}
