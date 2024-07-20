//GFG
//Remove Half Nodes
//Time complexity: O(n)
//Space complexity: O(height of the binary tree)

public class RemoveHalfNodes {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(7);
        root.right = new Node(8);
        root.left.left = new Node(2);
        Node res = removeHalfNodes(root);
        printInorder(res);
    }

    // Return the root of the modified tree after removing all the half nodes.
    public static Node removeHalfNodes(Node root) {
        // Code Here
        if (root == null)
            return null;
        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);
        if (root.left == null && root.right != null)
            return root.right;
        if (root.left != null && root.right == null)
            return root.left;
        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
