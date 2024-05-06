//GFG
//Print all nodes that don't have sibling
//Time complexity: O(nlogn)
//Space complexity: O(Height of the tree) = O(n)

package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class PrintAllNodesThatDontHaveSibling {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(37);
        root.left = new Node(20);
        root.left.left = new Node(113);
        System.out.println(noSibling(root));
    }

    static ArrayList<Integer> noSibling(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        help(node, ans);
        Collections.sort(ans);
        if (ans.size() == 0)
            ans.add(-1);
        return ans;
    }

    static void help(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (root.left == null || root.right == null) {
            if (root.left != null)
                ans.add(root.left.data);
            if (root.right != null)
                ans.add(root.right.data);
        }
        help(root.left, ans);
        help(root.right, ans);
    }
}
