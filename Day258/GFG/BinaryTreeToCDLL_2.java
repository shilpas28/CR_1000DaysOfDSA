//GFG
//Binary Tree to CDLL
//Time complexity: O(N)
//Space complexity: O(h) , where h = height of tree

package GFG;

public class BinaryTreeToCDLL_2 {

    // Node defined as
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
        System.out.println(bTreeToClist(root).data);
    }

    static Node head = null, prev = null;

    // Function to convert binary tree into circular doubly linked list.
    static Node bTreeToClist(Node root) {
        // your code here
        inorder(root);
        // fixing the last node
        head.left = prev;
        prev.right = head;

        return head;
    }

    static void inorder(Node curr) {
        if (curr == null)
            return;

        inorder(curr.left);

        if (head == null)
            head = prev = curr;
        else {
            prev.right = curr;
            curr.left = prev;
        }
        // before moving right update prev to curr.
        prev = curr;
        inorder(curr.right);
    }
}
