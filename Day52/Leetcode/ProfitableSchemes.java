//Leetcode
//879. Profitable Schemes
//Time complexity: O(k * i * j) where k = profit length, i = no:of members and j = minimum profit
//Space complexity: O(i * j) where i = no:of members and j = minimum profit

package Leetcode;

public class ProfitableSchemes {

    public static void main(String[] args) {
        int n = 5, minProfit = 3;
        int[] group = { 2, 2 };
        int[] profit = { 2, 3 };
        System.out.println(profitableSchemes(n, minProfit, group, profit));
    }

    static int mod = (int) 1e9 + 7;

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int k = 1; k <= group.length; k++) {
            int g = group[k - 1];
            int p = profit[k - 1];
            for (int i = n; i >= g; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    dp[i][j] = (dp[i][j] + dp[i - g][Math.max(0, j - p)]) % mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[i][minProfit]) % mod;
        }
        return sum;
    }
}
