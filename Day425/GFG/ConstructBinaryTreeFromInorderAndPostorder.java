//GFG
//Construct Binary Tree from Inorder and Postorder
//Time complexity: O(N) - Hashmap returns the answer in constant time
//Space complexity: O(N) - We are using an external hashmap of size ‘N’a

package GFG;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
        Node res = buildTree(in, post, n);
        printInorder(res);
    }

    // Function to return a tree created from postorder and inoreder traversals.
    static Node buildTree(int in[], int post[], int n) {
        // Your code here
        if (in == null || post == null || in.length != post.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; ++i)
            hm.put(in[i], i);
        return buildTreePostIn(in, 0, in.length - 1, post, 0,
                post.length - 1, hm);
    }

    static Node buildTreePostIn(int[] inorder, int is, int ie, int[] postorder,
            int ps, int pe, HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie)
            return null;
        Node root = new Node(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        Node leftchild = buildTreePostIn(inorder, is, ri - 1, postorder, ps,
                ps + ri - is - 1, hm);
        Node rightchild = buildTreePostIn(inorder, ri + 1, ie, postorder,
                ps + ri - is, pe - 1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
