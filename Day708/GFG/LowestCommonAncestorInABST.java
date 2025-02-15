//GFG
//Lowest Common Ancestor in a BST - Brute Force Method
//Time complexity: O(N + log2N) where N is the number of nodes in the Binary Tree.
//Space complexity: O(log2N) where N is the number of nodes in the Binary Tree.

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorInABST {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        Node n1 = root.right.right;
        Node n2 = root.right.right.right;
        System.out.println(LCA(root, n1, n2).data);
    }

    // Function to find the lowest common
    // ancestor of two nodes in a binary tree
    static Node LCA(Node root, Node n1, Node n2) {
        // your code here.
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        // Find paths from the
        // root to the given nodes
        getPath(root, path1, n1.data);
        getPath(root, path2, n2.data);
        // Find the last common
        // element in the paths
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i))) {
            i++;
        }
        // The last common
        // element is the LCA
        return new Node(path1.get(i - 1));
    }

    // Function to find the path from the
    // root to a given node with value 'x'
    public static boolean getPath(Node root, List<Integer> arr, int x) {
        // Base case: If the current
        // node is null, return false
        if (root == null) {
            return false;
        }
        // Add the current node's
        // value to the path list
        arr.add(root.data);
        // If the current node's value is equal
        // to the target value 'x', return true
        if (root.data == x) {
            return true;
        }
        // Recursively search for the target value
        // 'x' in the left and right subtrees
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true;
        }
        // If the target value 'x' is not found
        // in the current path, backtrack
        arr.remove(arr.size() - 1);
        return false;
    }
}
