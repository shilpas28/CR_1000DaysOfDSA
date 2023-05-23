//GFG
//Construct a Full Binary Tree
//Time complexity: O(N^2)
//Space complexity: O(N), where N indicates number of nodes.

package GFG;

public class ConstructAFullBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int preOrder[] = { 0, 1, 2 };
        int preOrderMirror[] = { 0, 2, 1 };
        int size = preOrder.length;
        Node root = constructBTree(preOrder, preOrderMirror, size);
        inorder(root);
    }

    public static Node constructBTree(int pre[], int preM[], int size) {
        // your code here
        return recur(pre, 0, size - 1);
    }

    public static Node recur(int pre[], int l, int r) {
        int mid = (l + r) / 2;
        Node newNode = new Node(pre[l]);
        if (l < r) {
            newNode.left = recur(pre, l + 1, mid);
            newNode.right = recur(pre, mid + 1, r);
        }
        return newNode;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }
}
