//GFG
//Flatten BST to sorted list
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class FlattenBSTToSortedList {

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

    public static Node flattenBST(Node root) {
        // Code here
        ans = null;
        prev = null;
        help(root);
        return ans;
    }

    static Node prev = null, ans = null;

    static void help(Node root) {
        if (root == null)
            return;
        help(root.left);
        if (prev != null) {
            prev.right = root;
            prev.left = null;
        } else
            ans = root;
        prev = root;
        help(root.right);
        prev.left = null;
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
