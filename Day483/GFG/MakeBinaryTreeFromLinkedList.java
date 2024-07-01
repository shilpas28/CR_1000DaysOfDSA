//GFG
//Make Binary Tree From Linked List
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;

public class MakeBinaryTreeFromLinkedList {

    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Tree node = null;
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        node = convert(head, node);
    }

    public static Tree convert(Node head, Tree node) {
        int[] arr = makeArrayFromLinkedList(head);
        int n = arr.length;
        return constructBinaryTree(arr, 0, n);
    }

    static int[] makeArrayFromLinkedList(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node ptr = head;
        while (ptr != null) {
            list.add(ptr.data);
            ptr = ptr.next;
        }
        int sizeOfList = list.size();
        int[] ans = new int[sizeOfList];
        for (int i = 0; i < sizeOfList; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    static Tree constructBinaryTree(int[] arr, int ptr, int n) {
        if (ptr >= n)
            return null;
        Tree root = new Tree(arr[ptr]);
        root.left = constructBinaryTree(arr, 2 * ptr + 1, n);
        root.right = constructBinaryTree(arr, 2 * ptr + 2, n);
        return root;
    }

}
