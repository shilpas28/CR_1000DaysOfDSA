//GFG
//Binary Tree to DLL
//Time complexity: O(no. of nodes)
//Space complexity: O(height of the tree)

public class BinaryTreeToDLL {

    static class Node {
        Node left, right;
        int data;

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
        Node res = bToDLL(root);
        printList(res);
    }

    static Node head = null, lastNode = null;
    // Function to convert binary tree to doubly linked list and return it.
    static Node bToDLL(Node root) {
        // Your code here
        help(root);
        return head;
    }

    static void help(Node root) {
        if (root == null)
            return;
        help(root.left);
        if (head == null)
            head = root;
        if (lastNode != null)
            lastNode.right = root;
        root.left = lastNode;
        lastNode = root;
        help(root.right);
    }

    static void printList(Node head) {
        Node prev = head;
        while (head != null) {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }
        System.out.println();
        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.left;
        }
    }
}
