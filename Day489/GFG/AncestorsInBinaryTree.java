//GFG
//Ancestors in Binary Tree
//Time complexity: O(N)
//Space complexity: O(H) 

import java.util.ArrayList;
import java.util.Collections;

public class AncestorsInBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        int target = 7;
        System.out.println(Ancestors(root, target));
    }

    static ArrayList<Integer> ans;

    public static ArrayList<Integer> Ancestors(Node root, int target) {
        // add your code here
        ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        help(root, target, temp);
        Collections.reverse(ans);
        return ans;
    }

    static void help(Node root, int target, ArrayList<Integer> temp) {
        if (root == null)
            return;
        if (root.data == target) {
            ans.addAll(temp);
            return;
        }
        temp.add(root.data);
        help(root.left, target, temp);
        help(root.right, target, temp);
        temp.remove(temp.size() - 1);
    }
}
