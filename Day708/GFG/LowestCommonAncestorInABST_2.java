//GFG
//Lowest Common Ancestor in a BST - Optimal solution
//Time complexity: O(N) where N is the number of nodes in the binary tree as each node of the binary tree is visited exactly once.
//Space complexity: O(H) ~ O(N) where N is the number of nodes in the binary tree and H is the height of the Binary Tree. 

public class LowestCommonAncestorInABST_2 {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        Node n1 = root.right.right;
        Node n2 = root.right.right.right;
        System.out.println(LCA(root, n1, n2).data);
    }

    // Function to find the lowest common
    // ancestor of two nodes in a binary tree
    static Node LCA(Node root, Node n1, Node n2) {
        // your code here.
        // Base case: if the root is null or one
        // of the nodes is found, return the current root
        if (root == null || root == n1 || root == n2) {
            return root;
        }
        // Recursively find the lowest
        // common ancestor in the left subtree
        Node left = LCA(root.left, n1, n2);
        // Recursively find the lowest
        // common ancestor in the right subtree
        Node right = LCA(root.right, n1, n2);
        // If the left subtree doesn't contain the
        // common ancestor, return the right subtree result
        if (left == null) {
            return right;
        }
        // If the right subtree doesn't contain the
        // common ancestor, return the left subtree result
        else if (right == null) {
            return left;
        }
        // If both subtrees contain the nodes, the
        // current root is the lowest common ancestor
        else {
            return root;
        }
    }
}
