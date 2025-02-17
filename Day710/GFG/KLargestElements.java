//GFG
//k largest elements
//Time complexity: O(k+(n-k)*logk)
//Space complexity: O(k+(n-k)*logk)

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {

    public static void main(String[] args) {
        int arr[] = { 12, 5, 787, 1, 23 };
        int k = 2;
        System.out.println(kLargest(arr, k));
    }

    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (pq.size() != 0) {
            ans.add(0, pq.poll());
        }
        return ans;
    }
}
