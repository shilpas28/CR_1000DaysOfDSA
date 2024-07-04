//GFG
//Duplicate Subtrees
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicateSubtrees {

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
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        System.out.println(printAllDups(root));
    }

    public static List<Node> printAllDups(Node root) {
        // code here
        List<Node> ans = new ArrayList<>();
        HashMap<String, Integer> mm = new HashMap<>();
        help(root, ans, mm);
        return ans;
    }

    static String help(Node root, List<Node> ans, HashMap<String, Integer> mm) {
        if (root == null)
            return "#";
        String temp = Integer.toString(root.data) + " " + help(root.left, ans, mm) + " " + help(root.right, ans, mm);
        if (mm.get(temp) != null && mm.get(temp) == 1)
            ans.add(root);
        mm.put(temp, mm.getOrDefault(temp, 0) + 1);
        return temp;
    }
}
