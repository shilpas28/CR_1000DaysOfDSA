//GFG
//Min distance between two given nodes of a Binary Tree - Using BFS
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceBetween2GivenNodesOfABinaryTree_3 {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(11);
        root.left = new Node(22);
        root.right = new Node(33);
        root.left.left = new Node(44);
        root.left.right = new Node(55);
        root.right.left = new Node(66);
        root.right.right = new Node(77);
        int a = 77, b = 22;
        System.out.println(findDist(root, a, b));
    }

    static int findDist(Node root, int a, int b) {
        // Your code here
        Node LCA = lca(root, a, b);
        return findLevel(LCA, a) + findLevel(LCA, b); // bfs
    }

    static Node lca(Node root, int n1, int n2) {
        // Your code here
        if (root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left != null && right != null)
            return root;

        if (left != null && right == null)
            return left;
        else
            return right;
    }

    // bfs
    static int findLevel(Node root, int a) {
        if (root == null)
            return -1;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.data == a)
                    return level;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            level++;
        }
        return -1;
    }
}
