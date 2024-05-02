//GFG
//Serialize and deserialize a binary tree
//Time complexity: O(Number of nodes)
//Space complexity: O(Number of nodes)

package GFG;

import java.util.ArrayList;

public class SerializeAndDeserializeABinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        ArrayList<Integer> output = serialize(root);
        System.out.println(output);
        Node res = deSerialize(output);
        printInorder(res);
    }

    static ArrayList<Integer> al;

    // Function to serialize a tree and return a list containing nodes of tree.
    public static ArrayList<Integer> serialize(Node root) {
        // code here
        al = new ArrayList<Integer>();
        fun(root);
        return al;
    }

    static void fun(Node root) {
        if (root == null) {
            al.add(-1);
            return;
        }
        al.add(root.data);
        fun(root.left);
        fun(root.right);
    }

    static int index;

    // Function to deserialize a list and construct the tree.
    public static Node deSerialize(ArrayList<Integer> A) {
        // code here
        index = 0;
        return dfs(A);
    }

    static Node dfs(ArrayList<Integer> A) {
        if (index == A.size())
            return null;

        int val = A.get(index);
        index++;

        if (val == -1)
            return null;

        Node root = new Node(val);
        root.left = dfs(A);
        root.right = dfs(A);

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;
        // First recur on left subtree
        printInorder(root.left);
        // Now deal with the node
        System.out.print(root.data + " ");
        // Then recur on right subtree
        printInorder(root.right);
    }
}
