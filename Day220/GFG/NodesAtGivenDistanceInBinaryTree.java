//GFG
//Nodes at given distance in binary tree
//Time complexity: O(N*logN)
//Space complexity: O(Height of tree)

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NodesAtGivenDistanceInBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        int target = 8;
        int k = 2;
        System.out.println(KDistanceNodes(root, target, k));
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // return the sorted list of all nodes at k dist
        HashMap<Node, Node> parent_track = new HashMap<>();
        markParent(root, parent_track, target);

        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(findNode(root, target));
        visited.put(findNode(root, target), true);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k)
                break;
            level++;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && visited.get(curr.left) == null) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }

                if (curr.right != null && visited.get(curr.right) == null) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Node curr = q.poll();
            ans.add(curr.data);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void markParent(Node root, Map<Node, Node> parent_track, int target) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                parent_track.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent_track.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public static Node findNode(Node root, int target) {
        if (root == null || root.data == target)
            return root;

        Node left = findNode(root.left, target);
        Node right = findNode(root.right, target);

        return left != null ? left : right;
    }
}
