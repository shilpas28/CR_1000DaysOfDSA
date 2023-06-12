//GFG
//Rod Cutting
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;

public class RodCutting {

    public static void main(String[] args) {
        int N = 8;
        int Price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(cutRod(Price, N));
    }

    public static int cutRod(int price[], int n) {
        // code here
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= n; i++) {
            int temp = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                temp = Math.max(temp, price[j] + dp[i - j - 1]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}
