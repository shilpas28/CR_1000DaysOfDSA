//GFG
//Root to Leaf Paths
//Time complexity: O(N)
//Space complexity: O(H*L) - where H is height and L is number of leaf nodes

package GFG;

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
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
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
