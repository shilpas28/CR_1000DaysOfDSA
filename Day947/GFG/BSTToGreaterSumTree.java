//GFG
//BST to greater sum tree
//Time complexity: O(N)
//Space complexity: O(N) 

public class BSTToGreaterSumTree {

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
        Node root = new Node(11);
        root.left = new Node(2);
        root.right = new Node(29);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);
        transformTree(root);
        printInorder(root);
    }

    static int sum = 0;

    public static void transformTree(Node root) {
        // code here
        sum = 0;
        dfs(root);
    }

    static void dfs(Node root) {
        if (root != null) {
            dfs(root.right);
            int val = root.data;
            root.data = sum;
            sum += val;
            dfs(root.left);

        }
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
