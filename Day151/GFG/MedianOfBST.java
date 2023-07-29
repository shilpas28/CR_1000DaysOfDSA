//GFG
//Median Of BST - Storing inorder traversal
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.List;

public class MedianOfBST {

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
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(findMedian(root));
    }

    public static float findMedian(Node root) {
        // code here.
        if (root == null)
            return 0;
        List<Integer> al = new ArrayList<>();
        inorder(al, root);
        int n = al.size();
        if (n % 2 != 0) {
            return al.get((n + 1) / 2 - 1);
        } else {
            int mid1 = al.get(n / 2 - 1);
            int mid2 = al.get(n / 2);
            return ((float) (mid1 + mid2) / 2);
        }
    }

    static void inorder(List<Integer> al, Node root) {
        if (root == null)
            return;
        inorder(al, root.left);
        al.add(root.data);
        inorder(al, root.right);
    }
}
