//GFG - Using tabulation
//Maximum Number of coins
//Time complexity: O(N^3)
//Space complexity: O(N^2)

package GFG;

import java.util.ArrayList;

public class MaximumNumberOfCoins_1 {

    public static void main(String[] args) {
        int N = 2;
        // int a[]={5, 10};
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(10);
        System.out.println(maxCoins(N, a));
    }

    static int[][] dp;

    static int maxCoins(int N, ArrayList<Integer> arr) {
        // Write your code here
        dp = new int[N + 2][N + 2];

        arr.add(0, 1);
        arr.add(1);
        N = arr.size();
        for (int i = N - 2; i > 0; i--) {
            for (int j = 1; j <= N - 2; j++) {
                if (i <= j) {
                    int max = Integer.MIN_VALUE;
                    for (int b = i; b <= j; b++) {
                        int cost = arr.get(i - 1) * arr.get(b) * arr.get(j + 1) + dp[i][b - 1] + dp[b + 1][j];
                        max = Math.max(max, cost);
                    }
                    dp[i][j] = max;
                } else
                    dp[i][j] = 0;
            }
        }
        return dp[1][N - 2];
    }
}
