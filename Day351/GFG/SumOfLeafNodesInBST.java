//GFG
//Sum of leaf nodes in BST
//Time complexity:
//Space complexity: 

package GFG;

public class SumOfLeafNodesInBST {

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(67);
        root.left = new Node(34);
        root.right = new Node(82);
        root.left.left = new Node(12);
        root.left.right = new Node(45);
        root.right.left = new Node(78);
        System.out.println(sumOfLeafNodes(root));
    }

    public static int sumOfLeafNodes(Node root) {
        // code here
        if (root == null)
            return 0;
        // If root has no left or right child, return its data as it is a leaf node
        if (root.left == null && root.right == null)
            return root.data;
        // Recursively calculate the sum of leaf nodes in the left and right subtrees
        return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
    }
}
