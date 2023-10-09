//GFG
//Height of Binary Tree - using Level order traversal/BFS
//Time complexity: O(N) 
//Space complexity: O(N) (Queue data structure is used)

package GFG;

import java.util.LinkedList;

public class HeightOfBinaryTree_2 {

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
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        System.out.println(height(root));

    }

    // Function to find the height of a binary tree.
    static int height(Node node) {
        // code here
        if (node == null) {
            return 0;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Node remNode = queue.removeFirst();
                if (remNode.left != null) {
                    queue.addLast(remNode.left);
                }
                if (remNode.right != null) {
                    queue.addLast(remNode.right);
                }
            }
            level++;
        }
        return level;
    }
}
