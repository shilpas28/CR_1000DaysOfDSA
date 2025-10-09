//GFG
//Postorder Traversal
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;

public class PostorderTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(19);
        root.left = new Node(10);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.right = new Node(13);
        System.out.println(postOrder(root));
    }

    static ArrayList<Integer> res = new ArrayList<>();

    public static ArrayList<Integer> postOrder(Node root) {
        // code here
        if (root == null)
            return null;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.data);
        return res;
    }
}
