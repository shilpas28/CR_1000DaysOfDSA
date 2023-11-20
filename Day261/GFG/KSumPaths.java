//GFG
//K Sum Paths
//Time complexity: O(N)
//Space complexity: O(Height of Tree)

package GFG;

import java.util.HashMap;

public class KSumPaths {

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
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right.right = new Node(6);
        int K = 5;
        System.out.println(sumK(root, K));
    }

    static int mod = (int) 1e9 + 7;
    static int total = 0;

    public static int sumK(Node root, int k) {
        // code here
        HashMap<Integer, Integer> ending = new HashMap<>();
        ending.put(0, 1);
        solve(root, k, 0, ending);
        return total;
    }

    static void solve(Node root, int k, int sum, HashMap<Integer, Integer> ending) {
        if (root == null) {
            return;
        }
        sum += root.data;
        total = (total + ending.getOrDefault(sum - k, 0)) % mod;
        ending.put(sum, ending.getOrDefault(sum, 0) + 1);
        solve(root.left, k, sum, ending);
        solve(root.right, k, sum, ending);
        ending.put(sum, ending.get(sum) - 1);
    }
}
