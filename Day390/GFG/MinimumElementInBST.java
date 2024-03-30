//GFG
//Minimum element in BST
//Time complexity: O(Height of the BST)
//Space complexity: O(1)

package GFG;

public class MinimumElementInBST {

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
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        root.right = new Node(6);
        root.right.right = new Node(7);
        System.out.println(minValue(root));
    }

    // Function to find the minimum element in the given BST.
    static int minValue(Node root) {
        // code here
        if (root.left == null) {
            return root.data;
        }
        return minValue(root.left);
    }
}
