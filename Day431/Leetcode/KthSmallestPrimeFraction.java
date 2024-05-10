//Leetcode
//786. K-th Smallest Prime Fraction - Using PriorityQueue with optimization
//Time complexity: O((n + K) * logn), with n = arr.length
//Space complexity: O(n)

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(arr[a[0]] * arr[n - 1 - b[1]], arr[n - 1 - a[1]] * arr[b[0]]);
            }
        });
        
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { i, 0 });
        }

        while (--k > 0) {
            int[] p = pq.poll();

            if (++p[1] < n) {
                pq.offer(p);
            }
        }
        return new int[] { arr[pq.peek()[0]], arr[n - 1 - pq.peek()[1]] };
    }
}
