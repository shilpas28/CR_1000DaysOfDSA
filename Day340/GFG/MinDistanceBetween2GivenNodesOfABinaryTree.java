//GFG
//Min distance between two given nodes of a Binary Tree
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

import java.util.ArrayList;

public class MinDistanceBetween2GivenNodesOfABinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(11);
        root.left = new Node(22);
        root.right = new Node(33);
        root.left.left = new Node(44);
        root.left.right = new Node(55);
        root.right.left = new Node(66);
        root.right.right = new Node(77);
        int a = 77, b = 22;
        System.out.println(findDist(root, a, b));
    }

    static int findDist(Node root, int a, int b) {
        // Your code here
        ArrayList<Integer> curPath = new ArrayList<>();
        ArrayList<Integer> pathA = new ArrayList<>();
        ArrayList<Integer> pathB = new ArrayList<>();
        help(root, curPath, pathA, pathB, a, b);
        int i = 0, j = 0;
        while (i < pathA.size() && j < pathB.size()) {
            if (pathA.get(i) != pathB.get(j))
                break;
            i++;
            j++;
        }
        return pathA.size() - i + pathB.size() - j;
    }

    static void help(Node root, ArrayList<Integer> curPath, ArrayList<Integer> pathA, ArrayList<Integer> pathB, int a,
            int b) {
        if (root == null)
            return;
        curPath.add(root.data);
        if (root.data == a)
            pathA.addAll(curPath);
        if (root.data == b)
            pathB.addAll(curPath);
        help(root.left, curPath, pathA, pathB, a, b);
        help(root.right, curPath, pathA, pathB, a, b);
        curPath.remove(curPath.size() - 1);
    }
}
