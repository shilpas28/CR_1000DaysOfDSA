//GFG
//Inorder Traversal - Using Recursion
//Time complexity: O(N)
//Space complexity: O(H)

package GFG;

import java.util.ArrayList;

public class InorderTraversal {

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
        System.out.println(inOrder(root));
    }

    // Function to return a list containing the inorder traversal of the tree.
    static ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root, ans);
        return ans;
    }

    static void solve(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        solve(root.left, ans);
        ans.add(root.data);
        solve(root.right, ans);
    }
}
