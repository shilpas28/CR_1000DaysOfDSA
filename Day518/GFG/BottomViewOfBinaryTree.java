//GFG
//Bottom View of Binary Tree
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomViewOfBinaryTree {
    static class Node {
        int data;
        int hd;
        Node left, right;

        public Node(int key) {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        System.out.println(bottomView(root));
    }

    // Function to return a list containing the bottom view of the given tree.
    public static ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> mm = new HashMap<>();
        root.hd = 0;
        q.add(root);
        int mn = 0, mx = 0;
        while (!q.isEmpty()) {
            Node temp = q.remove();
            mm.put(temp.hd, temp.data);
            mn = Math.min(mn, temp.hd);
            mx = Math.max(mx, temp.hd);
            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                q.add(temp.right);
            }
        }
        for (int i = mn; i <= mx; i++) {
            ans.add(mm.get(i));
        }
        return ans;
    }
}
