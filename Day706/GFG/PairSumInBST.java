//GFG
//Pair Sum in BST - Brute Force - Not accepted as TLE
//Time complexity: O(N+N) where N is the number of nodes in the Binary Search Tree. To create the array that will store the 
//inorder sequence, we have to traverse the entire BST, hence O(N) and to apply the two pointer approach and get the pair 
//equal to sum again requires O(N) hence O(N+N) ~ O(2N) ~ O(N).
//Space complexity: O(N)where N is the number of nodes in the BST, as we have to store all the nodes in an additional data 
//structure array. The two pointer approach does not use any additional space hence the space complexity is O(N).

import java.util.Stack;

public class PairSumInBST {

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

    static class BSTIterator {
        Stack<Node> stack;

        BSTIterator(Node root, boolean reverse) {
            stack = new Stack<>();
            Node current = root;
            while (current != null) {
                stack.push(current);
                current = reverse ? current.right : current.left;
            }
        }

        boolean hasNext() {
            return !stack.isEmpty();
        }

        int next() {
            Node node = stack.pop();
            int val = node.data;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return val;
        }
    }

    // Function to find if there exists
    // a pair with a given sum in the BST
    static boolean findTarget(Node root, int target) {
        // Write your code here
        // Initialize a BSTIterator object
        // initialized with the root of the BST
        BSTIterator l = new BSTIterator(root, false);
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
