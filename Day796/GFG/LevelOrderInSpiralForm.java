//GFG
//Level Order in spiral form
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Stack;

public class LevelOrderInSpiralForm {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(findSpiral(root));
    }

    public static ArrayList<Integer> findSpiral(Node root) {
        // code here
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
