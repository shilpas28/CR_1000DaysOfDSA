//GFG
//BST with Dead End
//Time complexity: O(N)
//Space complexity: O(H)

public class BSTWithDeadEnd {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);
        System.out.println(isDeadEnd(root));
    }

    public static boolean isDeadEnd(Node root) {
        // Code here.
        return hasDeadEnd(root, 1, 10001);
    }

    public static boolean hasDeadEnd(Node root, int minVal, int maxVal) {
        if (root == null) {
            return false;
        }
        if (minVal == maxVal) {
            return true;
        }
        return hasDeadEnd(root.left, minVal, root.data - 1) ||
                hasDeadEnd(root.right, root.data + 1, maxVal);
    }
}
