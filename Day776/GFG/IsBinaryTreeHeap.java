//GFG
//Is Binary Tree Heap
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeHeap {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(97);
        root.left = new Node(46);
        root.right = new Node(37);
        root.left.left = new Node(12);
        root.left.right = new Node(3);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(9);
        root.right.left = new Node(7);
        root.right.right = new Node(31);
        System.out.println(isHeap(root));
    }

    static boolean isHeap(Node tree) {
        // code here
        Queue<Node> q = new LinkedList<>();
        q.add(tree);
        while (!q.isEmpty()) {
            int n = q.size();
            boolean nullChild = false;
            for (int i = 0; i < n; i++) {
                Node node = q.poll();

                if (node.left != null) {
                    if (nullChild)
                        return false;
                    if (node.data < node.left.data)
                        return false;
                    q.add(node.left);
                } else
                    nullChild = true;

                if (node.right != null) {
                    if (nullChild)
                        return false;
                    if (node.data < node.right.data)
                        return false;
                    q.add(node.right);
                } else
                    nullChild = true;
            }
        }
        return true;
    }
}
