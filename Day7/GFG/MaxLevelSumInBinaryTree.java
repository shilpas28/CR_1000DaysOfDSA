//GFG - using BFS
//Max Level Sum in Binary Tree
//Time complexity: O(N), where N is no of node.
//Space complexity: O(W), Where W is the max width of the tree

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumInBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(-5);
        root.left.left = new Node(-1);
        root.left.right = new Node(3);
        root.right.left = new Node(-2);
        root.right.right = new Node(6);
        System.out.println(maxLevelSum(root));

    }

    public static int maxLevelSum(Node root) {
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            // Sum of the current level
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                Node next = q.poll();
                levelSum = levelSum + next.data;

                if (next.left != null) {
                    q.add(next.left);
                }
                if (next.right != null) {
                    q.add(next.right);
                }
            }
            maxSum = Math.max(maxSum, levelSum); //Determine the max sum
        }
        return maxSum;
    }
}
