//GFG
//Flatten BST to sorted list
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class FlattenBSTToSortedList_2 {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        Node res = flattenBST(root);
        printList(res);
    }

    static Node prev;

    public static Node flattenBST(Node root) {
        // Code here
        Node newNode = new Node(-2);
        prev = newNode;
        inorder(root);
        prev.left = null;
        prev.right = null;
        return newNode.right;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            prev.left = null;
            prev.right = root;
            prev = root;
            inorder(root.right);
        }
    }

    static void printList(Node head) {
        while (head != null) {
            if (head.left != null)
                System.out.print("-1");
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }
}
