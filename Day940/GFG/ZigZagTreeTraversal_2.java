//GFG
//ZigZag Tree Traversal
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTreeTraversal_2 {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(zigZagTraversal(root));
    }

    static ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty() || !s1.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                al.add(temp.data);

                if (temp.left != null)
                    s2.push(temp.left);
                if (temp.right != null)
                    s2.push(temp.right);
            }
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                al.add(temp.data);

                if (temp.right != null)
                    s1.push(temp.right);
                if (temp.left != null)
                    s1.push(temp.left);
            }
        }
        return al;
    }
}
