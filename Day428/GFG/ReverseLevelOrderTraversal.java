//GFG
//Reverse Level Order Traversal
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(reverseLevelOrder(root));
    }

    public static ArrayList<Integer> reverseLevelOrder(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (q.size() != 0) {
            Node temp = q.remove();
            ans.add(temp.data);
            if (temp.right != null)
                q.add(temp.right);
            if (temp.left != null)
                q.add(temp.left);
        }
        Collections.reverse(ans);
        return ans;
    }
}
