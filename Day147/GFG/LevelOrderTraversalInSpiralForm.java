//GFG
//Level order traversal in spiral form
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {

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
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        ArrayList<Integer> res = findSpiral(root);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    // Function to return a list containing the level order
    // traversal in spiral form.
    // Your code here
    static ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (root == null)
            return al;
        if (root.left == null && root.right == null) {
            al.add(root.data);
            return al;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                al.add(temp.data);
                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                al.add(temp.data);
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
        return al;
    }
}
