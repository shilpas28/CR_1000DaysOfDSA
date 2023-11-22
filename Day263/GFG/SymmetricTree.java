//GFG
//Symmetric Tree
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

import java.util.Stack;

public class SymmetricTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.left.left = new Node(2);
        root.right = new Node(1);
        root.right.right = new Node(2);
        System.out.println(isSymmetric(root));
    }

    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root) {
        // add your code here;
        if (root == null)
            return true;

        Stack<Node> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);

        while (!st.isEmpty()) {
            Node t1 = st.pop(), t2 = st.pop();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.data != t2.data)
                return false;

            st.push(t1.right);
            st.push(t2.left);
            st.push(t1.left);
            st.push(t2.right);
        }
        return true;
    }
}
