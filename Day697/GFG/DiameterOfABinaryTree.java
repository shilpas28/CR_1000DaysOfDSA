//GFG
//Diameter of a Binary Tree - Brute Force 
//Time complexity: O(N*N) where N is the number of nodes in the Binary Tree.This arises as we calculate the diameter of each node 
//and to calculate the height of its left and right children, we traverse the tree which is proportional to the number of nodes.
//Since this calculation is performed for each node in the tree, the complexity becomes: O(N x N) ~ O(N^2).
//Space complexity: O(1) as no additional data structures or memory is allocated.O(H): Recursive Stack Space is used to calculate 
//the height of the tree at each node which is proportional to the height of the tree.The recursive nature of the getHeight 
//function, which incurs space on the call stack for each recursive call until it reaches the leaf nodes or the height of the tree.

public class DiameterOfABinaryTree {

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

    // Global variable to
    // store the diameter
    static int diameter = 0;

    // Function to find the
    // diameter of a binary tree
    static int diameter(Node root) {
        // Your code here
        // Start the recursive
        // traversal from the root
        calculateHeight(root);
        // Return the maximum diameter
        // found during traversal
        return diameter;
    }

    // Function to calculate
    // the height of a subtree
    static int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        // Recursively calculate the
        // height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        // Calculate the diameter at the current
        // node and update the global variable
        diameter = Math.max(diameter, leftHeight + rightHeight);
        // Return the height
        // of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
