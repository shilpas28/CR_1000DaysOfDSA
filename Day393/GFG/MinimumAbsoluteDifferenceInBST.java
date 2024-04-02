//GFG
//Minimum Absolute Difference In BST
//Time complexity: O(N)
//Space complexity: O(H)

package GFG;

public class MinimumAbsoluteDifferenceInBST {

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
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        System.out.println(absolute_diff(root));
    }

    static int ans = Integer.MAX_VALUE, previous = -1;

    static int absolute_diff(Node root) {
        // Your code here
        ans = Integer.MAX_VALUE;
        previous = -1;
        help(root);
        return ans;
    }

    static void help(Node root) {
        if (root == null)
            return;
        help(root.left);
        if (previous != -1)
            ans = Math.min(ans, Math.abs(root.data - previous));
        previous = root.data;
        help(root.right);
    }
}
