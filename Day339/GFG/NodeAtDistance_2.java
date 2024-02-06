//GFG
//Node at distance
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NodeAtDistance_2 {

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

    // Function to return count of nodes at a given distance from leaf nodes.
    static int printKDistantfromLeaf(Node root, int k) {
        // Write your code here
        ArrayList<Node> vec = new ArrayList<>();
        Set<Node> s = new HashSet<>();
        help(root, k, vec, s, 0);
        return s.size();
    }

    static void help(Node root, int k, ArrayList<Node> vec, Set<Node> s, int level) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (k == 0)
                s.add(root);
            else if (level - k >= 0)
                s.add(vec.get(level - k));
            return;
        }
        vec.add(root);
        help(root.left, k, vec, s, level + 1);
        help(root.right, k, vec, s, level + 1);
        vec.remove(vec.size() - 1);
    }
}
