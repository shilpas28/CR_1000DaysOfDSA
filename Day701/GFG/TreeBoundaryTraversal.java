//GFG
//Tree Boundary Traversal
//Time complexity: O(N)
//Space complexity: O(H)

import java.util.ArrayList;

public class TreeBoundaryTraversal {

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
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(boundaryTraversal(root));
    }

    static ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (node.left != null || node.right != null) {
            ans.add(node.data);
        }
        leftNodes(node.left, ans);
        addLeaves(node, ans);
        rightRevNodes(node.right, ans);
        return ans;
    }

    static void leftNodes(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        if (node.left != null) {
            ans.add(node.data);
            leftNodes(node.left, ans);
        } else if (node.right != null) {
            ans.add(node.data);
            leftNodes(node.right, ans);
        }
    }

    static void addLeaves(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        addLeaves(node.left, ans);
        if (node.left == null && node.right == null) {
            ans.add(node.data);
        }
        addLeaves(node.right, ans);
    }

    static void rightRevNodes(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        if (node.right != null) {

            rightRevNodes(node.right, ans);
            ans.add(node.data);
        } else if (node.left != null) {
            rightRevNodes(node.left, ans);
            ans.add(node.data);
        }
    }
}
