//GFG
//Node at distance
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

import java.util.HashSet;

public class NodeAtDistance {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        int k = 2;
        System.out.println(printKDistantfromLeaf(root, k));
    }

    static HashSet<Node> set;

    // Function to return count of nodes at a given distance from leaf nodes.
    static int printKDistantfromLeaf(Node root, int k) {
        // Write your code here
        set = new HashSet<>();
        dfs(root, k);
        return set.size();
    }

    static void dfs(Node root, int k) {
        if (root == null)
            return;
        dfs(root.left, k);
        if (isValid(root, k))
            set.add(root);
        dfs(root.right, k);

    }

    static boolean isValid(Node root, int k) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            return k == 0;
        }
        return isValid(root.left, k - 1) || isValid(root.right, k - 1);
    }
}
