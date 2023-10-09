//GFG
//Height of Binary Tree - using Recursion/DFS
//Time complexity: O(N) 
//Space complexity: O(1) Extra Space + O(H) Recursion Stack space, where H is the height of the binary tree.

package GFG;

public class HeightOfBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        System.out.println(height(root));

    }

    // Function to find the height of a binary tree.
    static int height(Node node) {
        // code here
        if (node == null)
            return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return 1 + Math.max(lh, rh);
    }
}
