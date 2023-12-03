//GFG
//Brothers From Different Roots
//Time complexity: O(N)
//Space complexity: O(N)  

package GFG;

import java.util.ArrayList;

public class BrothersFromDifferentRoots_2 {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);
        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);
        int x = 16;
        System.out.println(countPairs(root1, root2, x));
    }

    public static int countPairs(Node root1, Node root2, int x) {
        // Code here
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        inorder(root1, l1);
        inorder(root2, l2);
        int i = 0, j = l2.size() - 1;
        int c = 0;
        while (i < l1.size() && j >= 0) {
            int sum = l1.get(i) + l2.get(j);
            if (sum == x) {
                c++;
                i++;
                j--;
            } else if (sum > x) {
                j--;
            } else {
                i++;
            }

        }
        return c;
    }

    public static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
