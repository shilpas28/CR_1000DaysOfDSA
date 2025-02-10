//GFG
//K Sum Paths
//Time complexity: O(N)
//Space complexity: O(H)

import java.util.HashMap;
import java.util.Map;

public class KSumPaths {

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
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);
        root.right.right = new Node(2);
        int k = 7;
        System.out.println(sumK(root, k));
    }

    public static int sumK(Node root, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return get(root, map, 0, k);
    }

    static int get(Node root, Map<Integer, Integer> map, int sum, int k) {
        if (root == null)
            return 0;
        sum += root.data;
        int ans = 0;
        if (map.containsKey(sum - k)) {
            ans += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        ans += get(root.left, map, sum, k);
        ans += get(root.right, map, sum, k);
        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0) {
            map.remove(sum);
        }
        return ans;
    }
}
