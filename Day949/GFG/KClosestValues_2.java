//GFG
//K closest Values
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.List;

public class KClosestValues_2 {

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

    static ArrayList<Integer> InoL = new ArrayList<>();

    public static ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // code here
        store(root);
        int idx = lowerB(InoL, target);
        int left = idx - 1;
        int right = idx;

        ArrayList<Integer> ans = new ArrayList<>(); // <-- fix: declare ans

        while (k-- > 0) {
            if (left < 0) {
                ans.add(InoL.get(right++));
            } else if (right >= InoL.size()) {
                ans.add(InoL.get(left--));
            } else {
                if (Math.abs(InoL.get(left) - target) <= Math.abs(InoL.get(right) - target))
                    ans.add(InoL.get(left--));
                else
                    ans.add(InoL.get(right++));
            }
        }

        return ans;
    }

    public static void store(Node root) {
        if (root == null)
            return;
        store(root.left);
        InoL.add(root.data);
        store(root.right);
    }

    public static int lowerB(List<Integer> inor, int target) {
        int low = 0, high = inor.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (inor.get(mid) < target) {
                low = mid + 1;

            }

            else if (inor.get(mid) == target)
                return mid;

            else
                high = mid;
        }
        return low;
    }
}
