//GFG
//Right View of Binary Tree - Iterative solution
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree_2 {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);
        ArrayList<Integer> res = rightView(root);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    // Function to return list containing elements of right view of binary tree.
    // add code here.
    static ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> b = new ArrayList<Integer>();
        if (node == null) {
            return b;
        }
        // Declare a queue and add a root node
        Queue<Node> qu = new LinkedList<>();
        qu.add(node);
        // While queue is not empty
        while (!qu.isEmpty()) {
            // no. of record present in a queue
            int len = qu.size();
            for (int i = 0; i < len; i++) {
                Node newNode = qu.poll();
                // Print last record of each level
                if (i == len - 1) { // if(i==0) for left view
                    b.add(newNode.data);
                }

                if (newNode.left != null) {
                    qu.add(newNode.left);
                }

                if (newNode.right != null) {
                    qu.add(newNode.right);
                }
            }
        }
        return b;
    }
}
