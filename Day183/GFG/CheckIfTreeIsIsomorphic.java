//GFG
//Check if Tree is Isomorphic
//Time complexity: O(min(M, N)) where M and N are the sizes of the two trees.
//Space complexity: O(min(H1, H2)) where H1 and H2 are the heights of the two trees.

public class CheckIfTreeIsIsomorphic {

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

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.right = new Node(4);

        System.out.println(isIsomorphic(root1, root2));
    }

    // Return True if the given trees are isomotphic. Else return False.
    static boolean isIsomorphic(Node root1, Node root2) {
        // code here.
        // BC1.
        if (root1 == null && root2 == null)// both tree empty
            return true;

        // BC2.
        if (root1 == null || root2 == null) // one of the tree empty
            return false; // if asked for how many swaps req:c++ at BC where returning fals.

        if (root1.data != root2.data)
            return false;

        else
            return (isIsomorphic(root1.right, root2.right) && isIsomorphic(root1.left, root2.left)
                    || isIsomorphic(root1.right, root2.left) && isIsomorphic(root1.left, root2.right));
    }
}
