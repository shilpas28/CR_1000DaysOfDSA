//GFG
//Bottom View of Binary Tree
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

import java.util.ArrayList;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(bottomView(root));
    }

    public static ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>(); // to store final ans
        TreeMap<Integer, int[]> map = new TreeMap<>(); // why TreeMap not HashMap? : to get the sorted order of the
                                                       // items
        solve(root, 0, 0, map); // start from root, hz=0, level=0
        for (Integer n : map.keySet()) {
            list.add(map.get(n)[0]);
        }
        return list;
    }

    static void solve(Node root, int hzDist, int level, TreeMap<Integer, int[]> map) {
        if (root == null)
            return;
        // Agar is horizontal distance (hd) pe koi node abhi tak nahi hai
        // YA phir jo node pehle stored hai uska level <= current node ka level (matlab
        // upar ka tha),
        // to ab isko update kar do (kyunki hamesha neeche wali node hi bottom view me
        // dikhni chahiye)
        if (!map.containsKey(hzDist) || map.get(hzDist)[1] <= level) {
            map.put(hzDist, new int[] { root.data, level });
        }
        // recursively check go for left and right subtree
        solve(root.left, hzDist - 1, level + 1, map);
        solve(root.right, hzDist + 1, level + 1, map);
    }
}
