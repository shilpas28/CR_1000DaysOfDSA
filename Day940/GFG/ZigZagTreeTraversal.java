//GFG
//ZigZag Tree Traversal
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTreeTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
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
        System.out.println(zigZagTraversal(root));
    }

    static ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;
        while (!q.isEmpty()) {
            int qSize = q.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                Node node = q.remove();
                levelList.add(node.data);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            if (reverse)
                Collections.reverse(levelList);
            ans.addAll(levelList);
            reverse = !reverse;
        }
        return ans;
    }
}
