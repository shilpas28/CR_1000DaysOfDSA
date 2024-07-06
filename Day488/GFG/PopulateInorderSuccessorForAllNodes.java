//GFG
//Populate Inorder Successor for all nodes
//Time complexity: O(N)
//Space complexity: O(H)

public class PopulateInorderSuccessorForAllNodes {

    static class Node {
        int data;
        Node left, right, next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        populateNext(root);
    }

    static Node nxt = null;

    public static void populateNext(Node root) {
        // code here
        if (root == null)
            return;
        populateNext(root.right);
        root.next = nxt;
        nxt = root;
        populateNext(root.left);
    }
}
