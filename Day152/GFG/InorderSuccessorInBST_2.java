//GFG
//Inorder Successor in BST - Optimized approach
//Time complexity: O(Height of the BST).
//Space complexity: O(1)

public class InorderSuccessorInBST_2 {
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
        Node ans = null;
        while (root != null) {
            if (root.data <= x.data) {
                root = root.right;
            } else {
                ans = root;
                root = root.left;
            }
        }
        return ans;
    }

}
