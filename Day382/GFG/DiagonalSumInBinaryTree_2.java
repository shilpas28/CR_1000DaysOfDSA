//GFG
//Diagonal sum in binary tree - Using BFS 
//Time complexity: O(n)
//Space complexity: O(h) where h is height of tree

package GFG;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DiagonalSumInBinaryTree_2 {

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

    public static ArrayList<Integer> diagonalSum(Node root) {
        // code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        if (root == null)
            return ans;
        while (!q.isEmpty()) {
            int sz = q.size(), sum = 0;
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                while (cur != null) {
                    if (cur.left != null)
                        q.offer(cur.left);
                    sum += cur.data;
                    cur = cur.right;
                }
            }
            ans.add(sum);
        }
        return ans;
    }
}
