//Leetcode
//714. Best Time to Buy and Sell Stock with Transaction Fee
//Time complexity: O(N*2) 
//Space complexity: O(N*2) + O(N)

package Leetcode;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        if (n == 0)
            return 0;
        int ans = getAns(prices, 0, 0, n, fee, dp);
        return ans;
    }

    static int getAns(int[] Arr, int ind, int buy, int n, int fee, int[][] dp) {

        if (ind == n)
            return 0; // base case
        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        int profit = 0;
        if (buy == 0) {// We can buy the stock
            profit = Math.max(0 + getAns(Arr, ind + 1, 0, n, fee, dp), -Arr[ind] + getAns(Arr, ind + 1, 1, n, fee, dp));
        }
        if (buy == 1) {// We can sell the stock
            profit = Math.max(0 + getAns(Arr, ind + 1, 1, n, fee, dp),
                    Arr[ind] - fee + getAns(Arr, ind + 1, 0, n, fee, dp));
        }
        return dp[ind][buy] = profit;
    }
}
