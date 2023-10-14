//GFG
//Find Common Nodes in two BSTs
//Time complexity: O(N1+N2) where N1 and N2 are the sizes of the 2 BSTs.
//Space complexity: O(H1+H2) where H1 and H2 are the heights of the 2 BSTs.

package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class FindCommonNodesInTwoBSTs_3 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(1);
        root1.right = new Node(10);
        root1.left.left = new Node(0);
        root1.left.right = new Node(4);
        root1.right.left = new Node(7);
        root1.right.left.right = new Node(9);

        Node root2 = new Node(10);
        root2.left = new Node(7);
        root2.right = new Node(20);
        root2.left.left = new Node(4);
        root2.left.right = new Node(9);

        System.out.println(findCommon(root1, root2));
    }

    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (true) {
            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            } else if (s1.size() > 0 && s2.size() > 0) {
                root1 = s1.peek();
                root2 = s2.peek();

                if (root1.data == root2.data) {
                    list.add(root1.data);
                    s1.pop();
                    s2.pop();
                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.data < root2.data) {
                    s1.pop();
                    root1 = root1.right;
                    root2 = null;
                } else {
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            } else
                break;
        }
        return list;
    }
}
