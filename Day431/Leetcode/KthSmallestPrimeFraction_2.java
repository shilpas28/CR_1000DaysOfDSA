//Leetcode
//786. K-th Smallest Prime Fraction - Using Binary Search
//Time complexity: O(n * log(MAX^2)), where MAX is the maximum element in arr
//Space complexity: O(1)

import java.util.Arrays;

public class KthSmallestPrimeFraction_2 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double l = 0, r = 1;
        int p = 0, q = 1;

        for (int n = arr.length, cnt = 0; true; cnt = 0, p = 0) {
            double m = (l + r) / 2;

            for (int i = 0, j = n - 1; i < n; i++) {
                while (j >= 0 && arr[i] > m * arr[n - 1 - j])
                    j--;
                cnt += (j + 1);

                if (j >= 0 && p * arr[n - 1 - j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[n - 1 - j];
                }
            }

            if (cnt < k) {
                l = m;
            } else if (cnt > k) {
                r = m;
            } else {
                return new int[] { p, q };
            }
        }
    }
}
