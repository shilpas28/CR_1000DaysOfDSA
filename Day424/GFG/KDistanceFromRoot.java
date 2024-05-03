//GFG
//K distance from root
//Time complexity: O(n)
//Space complexity: O(Height of the Tree)

package GFG;

import java.util.ArrayList;

public class KDistanceFromRoot {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(3);
        int k = 3;
        System.out.println(Kdistance(root, k));
    }

    // Recursive function to print right view of a binary tree.
    static ArrayList<Integer> Kdistance(Node root, int k) {
        // Your code here
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        kDistanceUtil(root, k, nodes);
        return nodes;
    }

    static void kDistanceUtil(Node root, int k, ArrayList<Integer> nodes) {

        if (root == null)
            return;

        if (k == 0) {
            nodes.add(root.data);
            return;
        }

        kDistanceUtil(root.left, k - 1, nodes);
        kDistanceUtil(root.right, k - 1, nodes);
    }

}
