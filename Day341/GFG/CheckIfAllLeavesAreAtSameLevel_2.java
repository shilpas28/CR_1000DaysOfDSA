//GFG
//Check if all leaves are at same level - Using BFS
//Time complexity: O(n)
//Space complexity: O(height of tree)

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfAllLeavesAreAtSameLevel_2 {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        // tree 1
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        // tree 2
        Node root1 = new Node(10);
        root1.left = new Node(20);
        root1.right = new Node(30);
        root1.left.left = new Node(10);
        root1.left.right = new Node(15);
        // function calls
        System.out.println(check(root));
        System.out.println(check(root1));
    }

    static boolean check(Node root) {
        // Your code here
        if (root == null)
            return true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        boolean firstLeaf = true;
        int leafLevel = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left == null && curr.right == null) {
                    if (firstLeaf) {
                        leafLevel = level;
                        firstLeaf = false;
                    } else if (level != leafLevel)
                        return false;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            level++;
        }
        return true;
    }
}
