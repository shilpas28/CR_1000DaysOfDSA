//GFG
//Check for BST
//Time complexity: O(N) for traversing N nodes.
//Space complexity: O(1) if we ignore the auxiliary stack space.

public class CheckForBST {

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
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.right.right = new Node(5);
        System.out.println(isBST(root));
    }

    // Function to check whether a Binary Tree is BST or not.
    static boolean isBST(Node root) {
        // code here.
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean checkBST(Node node, long min, long max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;

        if (checkBST(node.left, min, node.data) && checkBST(node.right, node.data,
                max)) {
            return true;
        }
        return false;
    }
}
