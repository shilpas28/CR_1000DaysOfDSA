//GFG
//Normal BST to Balanced BST
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayList;

public class NormalBSTToBalancedBST {

    static class Node {
        int data;
        Node right, left;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(20);
        root.left.left = new Node(10);
        Node res = buildBalancedTree(root);
        printInorder(res);
    }

    static Node buildBalancedTree(Node root) {
        // Add your code here.
        ArrayList<Node> list = new ArrayList<>();
        inorder(root, list);
        return bbst(list, 0, list.size() - 1);
    }

    static void inorder(Node root, ArrayList<Node> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    static Node bbst(ArrayList<Node> list, int l, int r) {
        if (l > r)
            return null;

        int mid = (l + r) / 2;

        Node root = list.get(mid);
        root.left = bbst(list, l, mid - 1);
        root.right = bbst(list, mid + 1, r);

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;
        // First recur on left subtree
        printInorder(root.left);
        // Now deal with the node
        System.out.print(root.data + " ");
        // Then recur on right subtree
        printInorder(root.right);
    }
}
