//GFG
//Floor in BST
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class FloorInBST {

    static class Node {

        int data;
        Node right;
        Node left;

        Node(int val) {
            data = val;
            right = null;
            left = null;
        }

    }

    public static void main(String[] args) {
        int x = 87;
        Node root = new Node(2);
        root.right = new Node(81);
        root.right.left = new Node(42);
        root.right.right = new Node(81);
        root.right.left.right = new Node(66);
        root.right.left.right.left = new Node(45);
        root.right.right = new Node(87);
        root.right.right.right = new Node(90);
        System.out.println(floor(root, x));
    }

    public static int floor(Node root, int x) {
        // Code here
        int floor = -1;
        while (root != null) {
            if (root.data == x)
                return x;
            else if (root.data < x) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}
