//GFG
//Max min Height
//Time complexity: O(nlogm)
//Space complexity: O(n)

import java.util.Arrays;

public class MaxMinHeight {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 1 };
        int k = 2, w = 2;
        System.out.println(maxMinHeight(arr, k, w));
    }

    public static int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int n = arr.length;
        long ans = 0;
        long min = 0, max = (long) 1e14;
        while (min <= max) {
            long mid = (min + max) / 2;
            if (isvalid(arr, n, k, w, mid)) {
                min = mid + 1;
                ans = mid;
            } else {
                max = mid - 1;
            }
        }
        return (int) ans;
    }

    public static boolean isvalid(int[] a, int n, int k, int w, long mid) {
        long[] heights = new long[n];
        Arrays.fill(heights, 0);
        long days = 0;
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0)
                heights[i] += heights[i - 1];
            if (a[i] + heights[i] < mid) {
                long diff = mid - a[i] - heights[i];
                days += diff;
                heights[i] += diff;
                if (i + w < n)
                    heights[i + w] -= diff;
            }
        }
        return (days <= k);
    }
}
