//GFG
//Diagonal sum in binary tree - Using DFS 
//Time complexity: O(n)
//Space complexity: O(h) where h is height of tree

package GFG;

import java.util.ArrayList;

public class DiagonalSumInBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        System.out.println(diagonalSum(root));
    }

    static ArrayList<Integer> res;

    public static ArrayList<Integer> diagonalSum(Node root) {
        // code here.
        res = new ArrayList<Integer>();
        dfs(root, 0);
        return res;
    }

    static void dfs(Node root, int l) {
        if (root == null)
            return;

        if (res.size() <= l) {
            res.add(root.data);
        } else {
            res.set(l, res.get(l) + root.data);
        }
        dfs(root.right, l);
        dfs(root.left, l + 1);
    }
}
