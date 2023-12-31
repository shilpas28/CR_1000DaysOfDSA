//GFG
//New Year Resolution
//Time complexity: O(N*(Sum of coins))
//Space complexity: O(N*(Sum of coins))

package GFG;

import java.util.Arrays;

public class NewYearResolution {

    public static void main(String[] args) {
        int N = 8;
        int[] coins = { 5, 8, 9, 10, 14, 2, 3, 5 };
        System.out.println(isPossible(N, coins));
    }

    public static boolean isPossible(int N, int[] coins) {
        // code here
        int total = Arrays.stream(coins).sum();
        boolean[][] possibility = new boolean[N + 1][total + 1];
        for (int i = 0; i <= N; i++) {
            possibility[i][0] = true;
        }
        for (int i = 1; i <= total; i++) {
            possibility[0][i] = false;
        }
        for (int idx = 1; idx <= N; idx++) {
            for (int sum = 1; sum <= total; sum++) {
                if (sum < coins[idx - 1]) {
                    possibility[idx][sum] = possibility[idx - 1][sum];
                }
                if (sum >= coins[idx - 1]) {
                    possibility[idx][sum] = possibility[idx - 1][sum] || possibility[idx - 1][sum - coins[idx - 1]];
                }
            }
        }
        for (int sum = 1; sum <= total; sum++) {
            if ((sum % 20 == 0 || sum % 24 == 0 || sum == 2024) && possibility[N][sum]) {
                return true;
            }
        }
        return false;
    }
}
