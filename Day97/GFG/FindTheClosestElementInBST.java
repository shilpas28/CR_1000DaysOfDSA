//GFG
//Find the Closest Element in BST
//Time complexity: O(Height of the BST)
//Space complexity: O(Height of the BST)

public class FindTheClosestElementInBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(11);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        root.left.right.left.right = new Node(4);
        int K = 13;
        System.out.println(minDiff(root, K));
    }

    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    static int minDiff(Node root, int K) {
        // Write your code here
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.data == K) // if node is fonnd return 0;
            return 0;
        if (root.data > K)
            return Math.min(root.data - K, minDiff(root.left, K));
        // else we call the function recursively for the right subtree.
        return Math.min(K - root.data, minDiff(root.right, K));
    }
}
