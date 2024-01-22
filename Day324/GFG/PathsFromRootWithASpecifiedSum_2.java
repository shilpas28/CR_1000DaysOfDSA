//GFG
//Paths from root with a specified sum - Same logic as the other solution but slightly shorter
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;

public class PathsFromRootWithASpecifiedSum_2 {

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
        int sum = 8;
        Node root = new Node(1);
        root.left = new Node(20);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right = new Node(15);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println(printPaths(root, sum));
    }

    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        solve(root, sum, list, res, 0);
        return res;
    }

    static void solve(Node root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res, int t) {
        if (root == null)
            return;
        list.add(root.data);
        t = t + root.data;

        if (t == sum)
            res.add(new ArrayList<>(list));
        solve(root.left, sum, list, res, t);
        solve(root.right, sum, list, res, t);

        list.remove(list.size() - 1);
    }
}
