//GFG
//Duplicate subtree in Binary Tree
//Time complexity: ON)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class DuplicateSubtreeInBinaryTree {
    // A Binary Tree node

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
        root.right.right = new Node(2);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(5);
        System.out.println(dupSub(root));
    }

    static int dupSub(Node root) {
        // code here
        HashMap<String, Integer> mp = new HashMap<>();
        structure(mp, root);
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getKey().length() > 2 && entry.getValue() > 1) {
                return 1;
            }
        }
        return 0;
    }

    static String structure(HashMap<String, Integer> mp, Node root) {
        if (root == null) {
            return "";
        }
        String path = structure(mp, root.left) + Integer.toString(root.data) + structure(mp, root.right);
        mp.put(path, mp.getOrDefault(path, 0) + 1);
        return path;
    }
}
