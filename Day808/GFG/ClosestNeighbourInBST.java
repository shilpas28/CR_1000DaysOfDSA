//GFG
//Closest Neighbour in BST
//Time complexity: O(H)
//Space complexity: O(H)

package GFG;

public class ClosestNeighbourInBST {

    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(7);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(8);
        root.right.left = new Node(11);
        root.right.right = new Node(16);
        int k = 14;
        System.out.println(findMaxFork(root, k));
    }

    public static int findMaxFork(Node root, int k) {
        // code here.
        int ans = Integer.MIN_VALUE;
        while (root != null) {
            if (root.data == k)
                return k;
            else if (root.data < k) {
                ans = Math.max(ans, root.data);
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
