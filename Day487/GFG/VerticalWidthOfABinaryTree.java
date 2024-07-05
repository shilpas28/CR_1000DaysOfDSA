//GFG
//Vertical Width of a Binary Tree
//Time complexity: O(n)
//Space complexity: O(height of the tree)

public class VerticalWidthOfABinaryTree {

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println(verticalWidth(root));
    }

    static int mn = 0, mx = 0;

    // Function to find the vertical width of a Binary Tree.
    public static int verticalWidth(Node root) {
        // code here.
        if (root == null)
            return 0;
        mn = 0;
        mx = 0;
        help(root, 0);
        return mx + Math.abs(mn) + 1;
    }

    static void help(Node root, int pos) {
        if (root == null)
            return;
        mn = Math.min(mn, pos);
        mx = Math.max(mx, pos);
        help(root.left, pos - 1);
        help(root.right, pos + 1);
    }
}
