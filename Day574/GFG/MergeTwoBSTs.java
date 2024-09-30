//GFG
//Merge two BST 's
//Time complexity: O((m+n)*log(m+n))
//Space complexity: O(Height of BST1 + Height of BST2 + m + n)

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBSTs {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(6);

        System.out.println(merge(root1, root2));
    }

    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public static List<Integer> merge(Node root1, Node root2) {
        // Write your code here
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        help(root1, first);
        help(root2, second);
        int i = 0, j = 0;
        while (i < first.size() && j < second.size()) {
            if (first.get(i) <= second.get(j))
                ans.add(first.get(i++));
            else
                ans.add(second.get(j++));
        }
        while (i < first.size())
            ans.add(first.get(i++));
        while (j < second.size())
            ans.add(second.get(j++));
        return ans;
    }

    static void help(Node root, List<Integer> temp) {
        if (root == null)
            return;
        help(root.left, temp);
        temp.add(root.data);
        help(root.right, temp);
    }
}
