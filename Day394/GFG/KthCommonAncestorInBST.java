//GFG
//Kth common ancestor in BST
//Time complexity: O(Height of the Tree)
//Space complexity: O(Height of the Tree)

package GFG;

public class KthCommonAncestorInBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(20);
        root.right = new Node(50);
        root.right.left = new Node(40);
        root.right.right = new Node(60);
        int k = 2, x = 40, y = 60;
        System.out.println(kthCommonAncestor(root, k, x, y));
    }

    public static int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        int total = 1;
        Node temp = root;
        while (root != null) {
            if (root.data > x && root.data > y) {
                root = root.left;
                total++;
            } else if (root.data < x && root.data < y) {
                root = root.right;
                total++;
            } else
                break;
        }
        int c = 1;
        total -= k;
        total++;
        root = temp;
        while (root != null) {
            if (c == total)
                return root.data;
            if (root.data > x && root.data > y) {
                root = root.left;
                c++;
            } else if (root.data < x && root.data < y) {
                root = root.right;
                c++;
            } else
                break;
        }
        return -1;
    }
}
