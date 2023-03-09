//Max Min Height
//GFG
//Time complexity:
//Sapce complexity:

package Day8.GFG;

import java.util.Arrays;

public class MaxMinHeight {

    public static void main(String[] args) {
        int n = 6, k = 2, w = 3;
        int a[] = { 2, 2, 2, 2, 1, 1 };
        System.out.println(maximizeMinHeight(n, k, w, a));
    }

    public static long maximizeMinHeight(int n, int k, int w, int[] a) {
        // Write your code here
        long ans = 0;
        long min = 0, max = (long) 1e14;
        while (min <= max) {
            long mid = (min + max) / 2;
            if (isvalid(a, n, k, w, mid)) {
                min = mid + 1;
                ans = mid;
            } else {
                max = mid - 1;
            }
        }
        return ans;
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
