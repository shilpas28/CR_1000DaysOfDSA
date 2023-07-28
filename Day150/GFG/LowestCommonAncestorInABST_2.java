//GFG
//Lowest Common Ancestor in a BST - Optimal solution
//Time complexity: O(Height of the BST)
//Space complexity: O(Height of the BST)

public class LowestCommonAncestorInABST_2 {

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
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        int n1 = 7, n2 = 8;
        Node res = LCA(root, n1, n2);
        System.out.println(res.data);
    }

    // Function to find the lowest common ancestor in a BST.
    static Node LCA(Node root, int n1, int n2) {
        if (root.data > Math.max(n1, n2))
            return LCA(root.left, n1, n2);
        else if (root.data < Math.min(n1, n2))
            return LCA(root.right, n1, n2);
        return root;
    }
}
