//GFG
//K-th Largest Sum Contiguous Subarray
//Time complexity:  O(n^2 log k)
//Space complexity:  O(log k)

import java.util.PriorityQueue;

public class KthLargestSumContiguousSubarray {

    public static void main(String[] args) {
        int arr[] = { 2, 6, 4, 1 };
        int k = 3;
        System.out.println(kthLargest(arr, k));
    }

    public static int kthLargest(int[] arr, int k) {
        // code here
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                pq.add(sum);
                while (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}
