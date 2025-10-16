//GFG
//Remove BST keys outside given range
//Time complexity: O(N)
//Space complexity: O(N) 

public class RemoveBSTKeysOutsideGivenRange {

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
        int l = -10, r = 13;
        Node root = new Node(6);
        root.left = new Node(-13);
        root.right = new Node(14);
        root.left.right = new Node(-8);
        root.right.left = new Node(13);
        root.right.right = new Node(15);
        root.right.left.left = new Node(7);
        Node res = removekeys(root, l, r);
        printInorder(res);
    }

    static Node removekeys(Node root, int l, int r) {
        // code here
        if (root == null)
            return null;

        if (root.data < l) {
            return removekeys(root.right, l, r);
        }

        if (root.data > r) {
            return removekeys(root.left, l, r);
        }
        
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);
        return root;
    }

    static void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
