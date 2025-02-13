//GFG
//Pair Sum in BST - Optimal
//Time complexity: O(N) where N is the number of nodes in the BST as we have to traverse all the nodes using the i and j 
//pointers to find the pair with sum ‘k’.
//Space complexity: O(H) where H is the height of the Binary Search Tree as the BSTIterator class uses a stack to store the 
//nodes. At maximum the size of such a stack will be equal to the height of the Binary Tree.

import java.util.Stack;

public class PairSumInBST_2 {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(9);
        int target = 12;
        System.out.println(findTarget(root, target));
    }

    // BSTIterator class for iterating through BST nodes
    static class BSTIterator {
        // Stack to store nodes
        private Stack<Node> myStack;
        // Flag to determine traversal direction
        private boolean reverse;
        // Constructor initializing BSTIterator with the
        // root of the BST and traversal direction
        BSTIterator(Node root, boolean isReverse) {
            myStack = new Stack<>();
            reverse = isReverse;
            // Initialize the stack with nodes
            pushAll(root);
        }
        // Checks if there exists a
        // next element in the BST
        boolean hasNext() {
            // Returns true if the
            // stack is not empty
            return !myStack.empty();
        }
        // Retrieves the next smallest element
        // ie. inorder successor in the BST
        int next() {
            // Retrieve the top node from the stack
            Node tmpNode = myStack.pop();
            if (!reverse) {
                // If not in reverse mode,
                // add nodes from the right subtree
                pushAll(tmpNode.right);
            } else {
                // If in reverse mode,
                // add nodes from the left subtree
                pushAll(tmpNode.left);
            }
            // Return the value of the retrieved node
            return tmpNode.data;
        }
        // Helper function to push nodes into
        // the stack in a specific order
        private void pushAll(Node node) {
            while (node != null) {
                // Push the node onto the stack
                myStack.push(node);
                if (reverse) {
                    // Move to the right child
                    // if in reverse mode
                    node = node.right;
                } else {
                    // Move to the left child
                    // if not in reverse mode
                    node = node.left;
                }
            }
        }
    }

    static boolean findTarget(Node root, int target) {
        // Write your code here
        if (root == null) {
            // If the root is empty,
            // return false
            return false;
        }
        // Initialize two BSTIterators for
        // traversal in different directions

        // Left iterator
        BSTIterator l = new BSTIterator(root, false);
        // Right iterator
        BSTIterator r = new BSTIterator(root, true);
        // Get the next element from the left iterator
        int i = l.next();
        // Get the next element from the right iterator
        int j = r.next();
        // Loop to find the pair with the given sum
        while (i < j) {
            if (i + j == target) {
                // If the sum is found,
                // return true
                return true;
            } else if (i + j < target) {
                // Move to the next element
                // from the left iterator
                i = l.next();
            } else {
                // Move to the next element
                // from the right iterator
                j = r.next();
            }
        }
        // If no pair found, return false
        return false;
    }
}
