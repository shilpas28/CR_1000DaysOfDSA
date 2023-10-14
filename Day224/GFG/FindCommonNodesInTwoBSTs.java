//GFG
//Find Common Nodes in two BSTs - Not accepted as TLE
//Time complexity: O(N2+N1)
//Space complexity: O(N1)

package GFG;

import java.util.ArrayList;
import java.util.HashMap;

public class FindCommonNodesInTwoBSTs {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(1);
        root1.right = new Node(10);
        root1.left.left = new Node(0);
        root1.left.right = new Node(4);
        root1.right.left = new Node(7);
        root1.right.left.right = new Node(9);

        Node root2 = new Node(10);
        root2.left = new Node(7);
        root2.right = new Node(20);
        root2.left.left = new Node(4);
        root2.left.right = new Node(9);

        System.out.println(findCommon(root1, root2));
    }

    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2) {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        inorder(root1, hm);
        res(root2, hm, list);
        return list;
    }

    static void inorder(Node node, HashMap<Integer, Integer> hm) {
        if (node == null)
            return;
        inorder(node.left, hm);
        hm.put(node.data, 1);
        inorder(node.right, hm);
    }

    static void res(Node node, HashMap<Integer, Integer> hm, ArrayList<Integer> list) {
        if (node == null)
            return;
        res(node.left, hm, list);
        if (hm.containsKey(node.data))
            list.add(node.data);
        res(node.right, hm, list);
    }
}
