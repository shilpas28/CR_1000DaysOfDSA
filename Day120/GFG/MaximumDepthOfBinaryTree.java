//GFG
//Maximum Depth Of Binary Tree
//Time complexity: O(N)
//Space complexity: O(height of the tree)

package GFG;

public class MaximumDepthOfBinaryTree {

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
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(4);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(Node root) {
        // code here
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
