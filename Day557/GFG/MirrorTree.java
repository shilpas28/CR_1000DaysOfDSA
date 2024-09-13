//GFG
//Mirror Tree
//Time complexity: O(N)
//Space complexity: O(H)

public class MirrorTree {

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
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        mirror(root);
        printInorder(root);
    }

    // Function to convert a binary tree into its mirror tree.
    static void mirror(Node node) {
        // Your code here
        if (node == null)
            return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
