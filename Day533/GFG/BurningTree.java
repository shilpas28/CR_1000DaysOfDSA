//GFG
//Burning Tree - Method 1
//Time complexity: O(number of nodes)
//Space complexity: O(height of tree)

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurningTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.right = new Node(6);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);

        int target = 8;
        System.out.println(minTime(root, target));
    }

    public static int minTime(Node root, int target) {
        // Your code goes here
        Map<Node, Node> map = new HashMap<>();
        preorder(root, null, map);
        Node tar = findTargetNode(root, target);
        Set<Node> vis = new HashSet<>();
        vis.add(tar);
        Queue<Node> q = new LinkedList<>();
        q.add(tar);

        int level = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Node pop = q.remove();
                Node par = map.get(pop), left = pop.left, right = pop.right;

                if (par != null && !vis.contains(par)) {
                    vis.add(par);
                    q.add(par);
                }
                if (left != null && !vis.contains(left)) {
                    vis.add(left);
                    q.add(left);
                }
                if (right != null && !vis.contains(right)) {
                    vis.add(right);
                    q.add(right);
                }
            }
            level++;
        }
        return level - 1;
    }

    static Node findTargetNode(Node node, int x) {
        if (node == null || node.data == x)
            return node;
        Node left = findTargetNode(node.left, x);
        if (left != null)
            return left;
        return findTargetNode(node.right, x);
    }

    static void preorder(Node node, Node par, Map<Node, Node> map) {
        if (node == null)
            return;
        map.put(node, par);
        preorder(node.left, node, map);
        preorder(node.right, node, map);
    }
}
