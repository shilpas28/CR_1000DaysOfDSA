//GFG
//Closest Neighbour in BST
//Time complexity: O(Height of the BST)
//Space complexity: O(Height of the BST)

package GFG;

public class ClosestNeighbourInBST {

    static class Node {
        int key;
        Node left, right;

        Node(int x) {
            key = x;
            left = right = null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(21);
        root.right.right.left = new Node(19);
        root.right.right.right = new Node(25);
        int n = 24;
        System.out.println(findMaxForN(root, n));
    }

    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        int ans = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key == n)
                return n;
            else if (root.key < n) {
                ans = Math.max(ans, root.key);
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
