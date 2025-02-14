//GFG
//Fixing Two nodes of a BST
//Time complexity: O(N)
//Space complexity: O(H) 

public class FixingTwoNodesOfABST {

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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(20);
        correctBST(root);
        printInorder(root);
    }

    static Node first, middle, last, prev;

    static void correctBST(Node root) {
        // code here.
        first = middle = last = null;
        inorder(root);
        // If two nodes are not adjacent
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        // If two nodes are adjacent in in-order traversal
        else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    static void inorder(Node root) {
        if (root == null)
            return;
        // Left subtree
        inorder(root.left);
        // Detect misplaced nodes
        if (prev != null && prev.data > root.data) {
            if (first == null) {
                first = prev;
                middle = root; // First violation
            } else {
                last = root; // Second violation
            }
        }
        prev = root; // Update prev node
        // Right subtree
        inorder(root.right);
    }

    static void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
