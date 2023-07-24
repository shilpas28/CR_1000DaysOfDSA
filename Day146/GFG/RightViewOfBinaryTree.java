//GFG
//Right View of Binary Tree - Recursive solution
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

import java.util.ArrayList;

public class RightViewOfBinaryTree {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);
        ArrayList<Integer> res = rightView(root);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    // Function to return list containing elements of right view of binary tree.
    static int max_level;

    static ArrayList<Integer> rightView(Node node) {
        // add code here.
        ArrayList<Integer> al = new ArrayList<>();
        max_level = 0;
        if (node == null)
            return al;
        rightV(al, node, 1);
        return al;
    }

    static void rightV(ArrayList a, Node root, int level) {
        if (root == null)
            return;
        if (max_level < level) {
            a.add(root.data);
            max_level = level;
        }
        rightV(a, root.right, level + 1);
        rightV(a, root.left, level + 1);
    }
}
