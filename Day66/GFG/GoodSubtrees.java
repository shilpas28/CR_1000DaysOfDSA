//GFG
//Good Subtrees
//Time complexity: O(n*k)
//Space complexity: O(n+n*k), where n is the size of recursion stack.

import java.util.HashSet;

public class GoodSubtrees {
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
        root.left.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        int k = 2;
        System.out.println(goodSubtrees(root, k));
    }

    static int ans;

    public static int goodSubtrees(Node root, int k) {
        ans = 0;
        help(root, k);
        return ans;
    }

    public static HashSet<Integer> help(Node root, int k) {
        if (root == null)
            return new HashSet<>();
        HashSet<Integer> l = help(root.left, k);
        HashSet<Integer> r = help(root.right, k);

        HashSet<Integer> tot = new HashSet<>();
        for (int x : l)
            tot.add(x);

        for (int x : r)
            tot.add(x);

        tot.add(root.data);

        if (tot.size() <= k)
            ans++;

        return tot;
    }
}
