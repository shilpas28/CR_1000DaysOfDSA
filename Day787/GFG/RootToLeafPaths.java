//Leetcode
//3341. Find Minimum Time to Reach Last Room I
//Time complexity: O(M × N log(M × N))
//Space complexity: O(M × N)

import java.util.ArrayList;

public class RootToLeafPaths {

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
        System.out.println(Paths(root));
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        help(root, ans, temp);
        return ans;
    }

    static void help(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            temp.add(root.data);
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.addAll(temp);
            ans.add(temp2);
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.data);
        help(root.left, ans, temp);
        help(root.right, ans, temp);
        temp.remove(temp.size() - 1);
    }
}
