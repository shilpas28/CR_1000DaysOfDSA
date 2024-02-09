//GFG
//Check for Children Sum Property in a Binary Tree
//Time complexity: O(n)
//Space complexity: O(Height of the Tree)

package GFG;

public class CheckForChildrenSumPropertyInABinaryTree {

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
        return ChildSum(root) ? 1 : 0;
    }

    static boolean ChildSum(Node root) {
        // base condition
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        int sum = 0;
        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;

        return (root.data == sum && ChildSum(root.left) && ChildSum(root.right));
    }
}
