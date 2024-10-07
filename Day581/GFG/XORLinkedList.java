//GFG
//XOR Linked List
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;

public class XORLinkedList {

    static class Node {
        int data;
        Node npx;

        Node(int x) {
            data = x;
            npx = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        root.npx = insert(root.npx, 5);
        root.npx.npx = insert(root.npx.npx, 4);
        root.npx.npx.npx = insert(root.npx.npx.npx, 7);
        root.npx.npx.npx.npx = insert(root.npx.npx.npx.npx, 3);
        root.npx.npx.npx.npx.npx = insert(root.npx.npx.npx.npx.npx, 10);
        System.out.println(getList(root));
    }

    // function should insert the data to the front of the list
    static Node insert(Node head, int data) {
        // Code Here.
        Node newNode = new Node(data);
        newNode.npx = head;
        return newNode;
    }

    // function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        // Code Here.
        Node curr = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr.data);
            curr = curr.npx;
        }
        return list;
    }
}
