//GFG
//Vertical sum
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.TreeMap;

public class VerticalSum {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(verticalSum(root));
    }

    static TreeMap<Integer, Integer> map;

    public static ArrayList<Integer> verticalSum(Node root) {
        map = new TreeMap<>();
        solve(root, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    static void solve(Node node, int line_no) {
        if (node == null)
            return;
        map.merge(line_no, node.data, Integer::sum);
        solve(node.left, line_no - 1);
        solve(node.right, line_no + 1);
    }
}
