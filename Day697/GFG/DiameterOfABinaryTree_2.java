//GFG
//Diameter of a Binary Tree - Optimal Method 
//Time complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly 
//once during the postorder traversal.
//Space complexity: O(1) as no additional space or data structures is created that is proportional to the input size of the tree. 
//O(H) Recursive Stack Auxiliary Space : The recursion stack space is determined by the maximum depth of the recursion, which is 
//the height of the binary tree denoted as H. In the balanced case it is log2N and in the worst case its N.

public class DiameterOfABinaryTree_2 {

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
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        System.out.println(diameter(root));
    }

    // Function to find the
    // diameter of a binary tree
    static int diameter(Node root) {
        // Your code here
        // Initialize the variable to
        // store the diameter of the tree
        int[] diameter = new int[1];
        diameter[0] = 0;
        // Call the height function to traverse
        // the tree and calculate diameter
        height(root, diameter);
        // Return the calculated diameter
        return diameter[0];
    }

    // Function to calculate the height of
    // the tree and update the diameter
    static int height(Node node, int[] diameter) {
        // Base case: If the node is null,
        // return 0 indicating the
        // height of an empty tree
        if (node == null) {
            return 0;
        }
        // Recursively calculate the
        // height of left and right subtrees
        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0] = height(node.left, diameter);
        rh[0] = height(node.right, diameter);
        // Update the diameter with the maximum
        // of current diameter or sum of
        // left and right heights
        diameter[0] = Math.max(diameter[0], lh[0] + rh[0]);
        // Return the height of
        // the current node's subtree
        return 1 + Math.max(lh[0], rh[0]);
    }
}
