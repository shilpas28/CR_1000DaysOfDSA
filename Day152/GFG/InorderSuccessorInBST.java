//GFG
//Inorder Successor in BST - Naive approach
//Time complexity: O(N)
//Space complexity: O(N)

public class InorderSuccessorInBST {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node k = new Node(8);
        System.out.println(inorderSuccessor(root, k).data);
    }

    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public static Node inorderSuccessor(Node root, Node x) {
        // add code here.
        boolean[] found = { false };
        Node[] ans = { null };
        inorder(root, x, found, ans);
        return ans[0];
    }

    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public static void inorder(Node root, Node x, boolean[] found, Node[] ans) {
        if (root == null)
            return;
        inorder(root.left, x, found, ans);
        if (found[0] == true) {
            ans[0] = root;
            found[0] = false;
        }
        if (root.data == x.data) {
            found[0] = true;
        }
        inorder(root.right, x, found, ans);
    }

}
