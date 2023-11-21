//GFG
//Determine if Two Trees are Identical
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

public class DetermineIfTwoTreesAreIdentical {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(20);
        root1.right = new Node(30);
        Node root2 = new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        System.out.println(isIdentical(root1, root2));
    }

    // Function to check if two trees are identical.
    static boolean isIdentical(Node root1, Node root2) {
        // Code Here
        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;

        return ((root1.data == root2.data) && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right));
    }
}
