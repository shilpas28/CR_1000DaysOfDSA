//GFG
//Left View of Binary Tree
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeftViewOfBinaryTree {

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
        root.left.left.right = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(leftView(root));
    }

    // Function to return list containing elements of left view of binary tree.
    static ArrayList<Integer> leftView(Node root) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mm = new HashMap<>();
        help(root, ans, 0, mm);
        return ans;
    }

    static void help(Node root, ArrayList<Integer> ans, int level, Map<Integer, Integer> mm) {
        if (root == null)
            return;
        if (mm.get(level) == null) {
            ans.add(root.data);
            mm.put(level, 1);
        }
        level++;
        help(root.left, ans, level, mm);
        help(root.right, ans, level, mm);
    }
}
