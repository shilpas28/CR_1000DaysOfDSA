//GFG
//Inorder Traversal - Using Stack 
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal_2 {

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
        Stack<Node> st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        while (!st.isEmpty()) {
            Node tmp = st.pop();
            ans.add(tmp.data);
            if (tmp.right != null) {
                tmp = tmp.right;
                while (tmp != null) {
                    st.push(tmp);
                    tmp = tmp.left;
                }
            }
        }
        return ans;
    }
}
