//GFG
//Check for BST
//Time complexity: O(N)
//Space complexity: O(Height of the tree)

public class CheckForBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.right.right = new Node(5);
        System.out.println(isBST(root));
    }

    // Function to check whether a Binary Tree is BST or not.
    static boolean isBST(Node root) {
        // code here.
        return isBSTChecker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTChecker(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;
        return (isBSTChecker(node.left, min, node.data) && isBSTChecker(node.right, node.data, max));
    }
}
