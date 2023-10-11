//GFG
//Check for Balanced Tree
//Time complexity: O(N) 
//Space complexity: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree)

package GFG;

public class CheckForBalancedTree {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(isBalanced(root));
    }

    // Function to check whether a binary tree is balanced or not.
    static boolean isBalanced(Node root) {
        // Your code here
        return dfsHeight(root) != -1;
    }

    static int dfsHeight(Node root) {
        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
