//GFG
//Binary Tree to CDLL
//Time complexity: O(N)
//Space complexity: O(N+H)

package GFG;

import java.util.ArrayList;

public class BinaryTreeToCDLL {

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
    static ArrayList<Node> al;

    // Function to convert binary tree into circular doubly linked list.
    static Node bTreeToClist(Node root) {
        // your code here
        // Function to convert binary tree into circular doubly linked list.
        al = new ArrayList<>();
        inorder(root);
        // Traverse the array to make Circular Doubly Linked List
        int n = al.size();
        for (int i = 0; i < n; i++) {
            Node curr = al.get(i);
            if (head == null) {
                head = prev = curr;
            } else {
                prev.right = curr;
                curr.left = prev;
            }
            // Before moving to the next node, update prev to curr.
            prev = curr;

        }
        // Fixing the last node
        head.left = prev;
        prev.right = head;
        return head;
    }

    static void inorder(Node curr) {
        if (curr == null)
            return;

        inorder(curr.left);

        // Add the current node to the inorder list
        al.add(curr);
        inorder(curr.right);
    }

}
