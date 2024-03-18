//GFG
//Level order traversal
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(levelOrder(root));
    }

    // Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
            ans.add(n.data);
        }
        return ans;
    }
}
