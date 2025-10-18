//GFG
//Median of BST 
//Time complexity: O(N)
//Space complexity: O(N)

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
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(findMedian(root));
    }

    public static int findMedian(Node root) {
        // Code here
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int n = list.size();

        return n % 2 == 0 ? list.get((n / 2) - 1) : list.get(((n + 1) / 2) - 1); // doing -1 because of 0 based indexing
    }

    static void inorder(Node root, List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
