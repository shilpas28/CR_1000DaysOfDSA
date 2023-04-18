//GFG
//Minimum BST Sum Subtree
//Time complexity: O(N), where N is no. of nodes
//Space complexity: O(h), where h is the height of the tree

package GFG;

public class MinimumBSTSumSubtree {

    // Definition for Binary Tree Node
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
        Node root = new Node(13);
        root.left = new Node(5);
        root.left.right = new Node(17);
        root.left.right.left = new Node(16);
        root.right = new Node(23);
        int ans = 38;
        System.out.println(minSubtreeSumBST(ans, root));
    }

    static int ans = Integer.MAX_VALUE;

    public static int minSubtreeSumBST(int target, Node root) {
        // code here
        ans = Integer.MAX_VALUE;
        int temp[] = help(root, target);
        if (temp[0] == 1 && temp[2] == target) {
            ans = Math.min(ans, temp[1]);
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }

    static int[] help(Node root, int target) {
        if (root == null) {
            int[] arr = { 1, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE };
            return arr;
        }
        int[] l = help(root.left, target);
        int[] r = help(root.right, target);
        if (root.data <= l[4] || root.data >= r[3]) {
            int arr[] = { 0, 0, 0, 0, 0 };
            return arr;
        }
        int sum = root.data + l[2] + r[2];
        int n = 1 + l[1] + r[1];
        if (l[0] == 1 && r[0] == 1 && sum == target) {
            ans = Math.min(ans, n);
        }
        int arr[] = { l[0] & r[0], n, sum, Math.min(l[3], root.data), Math.max(r[4], root.data) };
        return arr;
    }
}
