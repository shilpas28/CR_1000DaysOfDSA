//GFG
//Maximum Tip Calculator
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.Comparator;

public class MaximumTipCalculator {

    public static void main(String[] args) {
        int n = 5, x = 3, y = 3;
        int[] arr = { 1, 2, 3, 4, 5 }, brr = { 5, 4, 3, 2, 1 };
        System.out.println(maxTip(n, x, y, arr, brr));
    }

    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = Math.abs(arr[i] - brr[i]);
            temp[i][1] = i;
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0])
                    return 1;
                else if (a[0] < b[0])
                    return -1;
                return 0;
            }
        });
        
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int index = temp[i][1];
            if (arr[index] > brr[index]) {
                if (x != 0) {
                    ans += arr[index];
                    x--;
                } else {
                    ans += brr[index];
                    y--;
                }
            } else {
                if (y != 0) {
                    ans += brr[index];
                    y--;
                } else {
                    ans += arr[index];
                    x--;
                }
            }
        }
        return ans;
    }
}
