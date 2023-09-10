//GFG
//Insert a node in a BST
//Time complexity: O(Height of the BST).
//Space complexity: O(Height of the BST).

package GFG;

public class InsertANodeInABST {
    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        int K = 4;
        insert(root, K);
        inorder(root);
    }

    // Function to insert a node in a BST.
    static Node insert(Node root, int Key) {
        // your code here
        if (root == null)
            root = new Node(Key);
        if (root.data > Key)
            root.left = insert(root.left, Key);
        if (root.data < Key)
            root.right = insert(root.right, Key);
        return root;
    }

    static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
