//GFG
//Vertical sum
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.HashMap;

public class VerticalSum_2 {

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

    static int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;

    public static ArrayList<Integer> verticalSum(Node root) {
        // add your code here
        HashMap<Integer, Integer> mm = new HashMap<>();
        help(root, mm, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = mn; i <= mx; i++) {
            if (mm.get(i) != null)
                ans.add(mm.get(i));
        }
        return ans;
    }

    static void help(Node root, HashMap<Integer, Integer> mm, int vLevel) {
        if (root == null)
            return;
        mn = Math.min(mn, vLevel);
        mx = Math.max(mx, vLevel);
        mm.put(vLevel, mm.getOrDefault(vLevel, 0) + root.data);
        help(root.left, mm, vLevel - 1);
        help(root.right, mm, vLevel + 1);
    }
}
