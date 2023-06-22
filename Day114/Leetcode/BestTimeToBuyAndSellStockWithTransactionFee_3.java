//Leetcode
//714. Best Time to Buy and Sell Stock with Transaction Fee
//Time complexity: O(N*2) 
//Space complexity: O(1)

package Leetcode;

public class BestTimeToBuyAndSellStockWithTransactionFee_3 {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0)
            return 0;
        long ahead[] = new long[2];
        long cur[] = new long[2];
        // base condition
        ahead[0] = ahead[1] = 0;
        long profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {// We can buy the stock
                    profit = Math.max(0 + ahead[0], -prices[ind] + ahead[1]);
                }
                if (buy == 1) {// We can sell the stock
                    profit = Math.max(0 + ahead[1], prices[ind] - fee + ahead[0]);
                }
                cur[buy] = profit;
            }
            ahead = (long[]) (cur.clone());
        }
        return (int)cur[0];
    }
}
