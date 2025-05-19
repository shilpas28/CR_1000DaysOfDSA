//GFG
//Predecessor and Successor
//Time complexity: O(Height of the BST)
//Space complexity: O(1)

import java.util.ArrayList;

public class PredecessorAndSuccessor {

    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(1);
        root.right = new Node(9);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(10);
        int key = 8;
        ArrayList<Node> lst = findPreSuc(root, key);
        for (Node val : lst) {
            System.out.print(val.data + " ");
        }
    }

    public static ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node ans[] = new Node[2];
        f(root, ans, key);
        ArrayList<Node> ret = new ArrayList<>();
        ret.add(ans[0]);
        ret.add(ans[1]);
        return ret;
    }

    public static void f(Node root, Node ans[], int key) {
        if (root == null)
            return;

        f(root.left, ans, key);

        if (root.data < key)
            ans[0] = root;
        if (ans[1] == null && root.data > key)
            ans[1] = root;

        f(root.right, ans, key);
    }
}
