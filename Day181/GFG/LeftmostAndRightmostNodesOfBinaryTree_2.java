//GFG
//Leftmost and rightmost nodes of binary tree
//Time complexity: O(N)
//Space complexity: O(number of nodes in a level)

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class LeftmostAndRightmostNodesOfBinaryTree_2 {
    // Node class of the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
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
        printCorner(root);
    }

    public static void printCorner(Node node) {

        // add your code here
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        boolean flag = false;

        while (q.size() > 0) {
            Node curr = q.remove();
            if (curr == null) {
                flag = true;
                if (q.size() == 0)
                    break;
                else
                    q.add(null);
            } else {
                if (q.peek() == null || flag == true) {
                    System.out.print(curr.data + " ");
                    flag = false;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }
}
