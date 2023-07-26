//GFG
//Kth Ancestor in a Tree
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class KthAncestorInATree {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int K = 2;
        int node = 4;
        System.out.println(kthAncestor(root, K, node));
    }

    static int num_node = 0;

    public static int kthAncestor(Node root, int k, int node) {
        // Write your code here
        // size of tree
        length(root);
        // store parent
        int parent[] = new int[num_node + 1];
        fill_parent(root, parent);
        // need to move k times
        int cnt = 0;
        while (node != -1) {
            node = parent[node];
            cnt++;
            if (cnt == k)
                return node;
        }
        return -1;
    }

    static void length(Node root) {
        if (root == null)
            return;
        length(root.right);
        num_node++;
        length(root.left);
    }

    static void fill_parent(Node root, int parent[]) {
        parent[root.data] = -1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
                parent[curr.left.data] = curr.data;
            }
            if (curr.right != null) {
                q.add(curr.right);
                parent[curr.right.data] = curr.data;
            }
        }
    }
}
