//GFG
//Level order traversal
//Time complexity: O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued 
//exactly once, hence all nodes need to be processed and visited. Processing each node takes constant time operations which 
//contributes to the overall linear time complexity.
//Space complexity: O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes 
//of the last level of the binary tree, the last level could at most hold N/2 nodes hence the space complexity of the queue is 
//proportional to O(N).The resultant vector answer also stores the values of the nodes level by level and hence contains all the 
//nodes of the tree contributing to O(N) space as well.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        root.left.right = new Node(50);
        System.out.println(levelOrder(root));
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        // Create a list of lists to store levels
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            // If the tree is empty,
            // return an empty list
            return ans;
        }
        // Create a queue to store nodes
        // for level-order traversal
        Queue<Node> q = new LinkedList<>();
        // Push the root node to the queue
        q.add(root);
        while (!q.isEmpty()) {
            // Get the size of the current level
            int size = q.size();
            // Create a list to store
            // nodes at the current level
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                Node node = q.poll();
                // Store the node value
                // in the current level list
                level.add(node.data);
                // Enqueue the child nodes if they exist
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // Store the current level
            // in the answer list
            ans.add((ArrayList<Integer>) level);
        }
        // Return the level-order
        // traversal of the tree
        return ans;
    }
}
