//GFG
//Sum of nodes on the longest path from root to leaf node
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.ArrayList;

public class SumOfNodesOnTheLongestPathFromRootToLeafNode {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        root.left.right.left = new Node(6);

        System.out.println(sumOfLongRootToLeafPath(root));
    }

    public static int sumOfLongRootToLeafPath(Node root) {
        // code here
        ArrayList<Integer> res = solve(root);
        return res.get(1);
    }

    static ArrayList<Integer> solve(Node root) {
        if (root == null) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(0);
            res.add(0);
            return res;
        }

        ArrayList<Integer> left = solve(root.left);
        ArrayList<Integer> right = solve(root.right);
        if (left.get(0) < right.get(0)) {
            right.set(0, right.get(0) + 1);
            right.set(1, right.get(1) + root.data);
            return right;
        } else if (left.get(0) > right.get(0)) {
            left.set(0, left.get(0) + 1);
            left.set(1, left.get(1) + root.data);
            return left;
        } else {
            right.set(0, right.get(0) + 1);
            right.set(1, Math.max(left.get(1), right.get(1)) + root.data);
            return right;
        }
    }
}
