//GFG
//k-th Smallest in BST - Brute Force 
//Time complexity: O(N)
//Space complexity: O(1)

public class KthSmallestInBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
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
        int k = 3;
        System.out.println(kthSmallest(root, k));
    }

    static int count = 0;
    static int res = -1;

    public static int kthSmallest(Node root, int k) {
        // Write your code here
        count = k;
        res = -1;
        utils(root);
        return res;
    }

    static void utils(Node root) {
        if (root == null) {
            return;
        }

        utils(root.left);
        --count;

        if (count == 0) {
            res = root.data;
            return;
        }

        utils(root.right);
    }
}
