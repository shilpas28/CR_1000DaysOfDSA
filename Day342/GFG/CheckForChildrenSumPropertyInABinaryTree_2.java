//GFG
//Check for Children Sum Property in a Binary Tree
//Time complexity: O(n)
//Space complexity: O(Height of the Tree)

package GFG;

public class CheckForChildrenSumPropertyInABinaryTree_2 {

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(35);
        root.left = new Node(20);
        root.right = new Node(15);
        root.left.left = new Node(15);
        root.left.right = new Node(5);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        System.out.println(isSumProperty(root));
    }

    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        if (root == null || (root.left == null && root.right == null))
            return 1;
        int left_data = 0;
        int right_data = 0;
        if (root.left != null)
            left_data = root.left.data;
        if (root.right != null)
            right_data = root.right.data;
        if (root.data == (left_data + right_data) && isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1)
            return 1;
        else
            return 0;
    }
}
