//Leetcode
//786. K-th Smallest Prime Fraction - Using Zigzag Search
//Time complexity: O(n^2)
//Space complexity: O(1)

import java.util.Arrays;

public class KthSmallestPrimeFraction_3 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;
        int row = 0;
        int col = n - 1;

        for (int cnt_le = 0, cnt_lt = 0; true; cnt_le = 0, cnt_lt = 0) {
            for (int i = 0, j = n - 1, p = n - 1; i < n; i++) {
                while (j >= 0 && arr[i] * arr[n - 1 - col] > arr[n - 1 - j] * arr[row])
                    j--;
                cnt_le += (j + 1);

                while (p >= 0 && arr[i] * arr[n - 1 - col] >= arr[n - 1 - p] * arr[row])
                    p--;
                cnt_lt += (p + 1);
            }

            if (cnt_le < k) {
                row++;
            } else if (cnt_lt >= k) {
                col--;
            } else {
                return new int[] { arr[row], arr[n - 1 - col] };
            }
        }
    }
}
