//GFG
//K closest Values
//Time complexity: O(nlogk)
//Space complexity: O(k + h)

package GFG;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KClosestValues {

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
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        int target = 17, k = 3;
        System.out.println(getKClosest(root, target, k));
    }

    public static ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0]; // max-heap by diff
            return b[1] - a[1]; // prefer larger value to remove first
        });

        inorder(root, pq, target, k);

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }

        return res;
    }

    static void inorder(Node root, PriorityQueue<int[]> pq, int target, int k) {
        if (root == null)
            return;

        inorder(root.left, pq, target, k);

        pq.add(new int[] { Math.abs(root.data - target), root.data });
        if (pq.size() > k)
            pq.poll(); // remove top values/nodes with largest diff

        inorder(root.right, pq, target, k);
    }
}
