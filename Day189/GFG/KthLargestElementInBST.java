//GFG
//Kth largest element in BST
//Time complexity: O(N).
//Space complexity: O(H) where H is max recursion stack of height H at a given time. 

package GFG;

public class KthLargestElementInBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(9);
        int k = 2;
        System.out.println(kthLargest(root, k));
    }

    // return the Kth largest element in the given BST rooted at 'root'
    static int count = 0;
    static int ans = 0;

    public static int kthLargest(Node root, int K) {
        // Your code here
        revInorder(root, K);
        return ans;
    }

    static void revInorder(Node root, int k) {
        if (root == null)
            return;
        revInorder(root.right, k);
        count++;
        if (count == k) {
            ans = root.data;
            return;
        }
        revInorder(root.left, k);
    }
}
