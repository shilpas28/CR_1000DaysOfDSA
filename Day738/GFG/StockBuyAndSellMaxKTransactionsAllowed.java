//GFG
//Stock Buy and Sell – Max K Transactions Allowed - Tabulation
//Time complexity: O(N*k)
//Space complexity: O(k) 

public class StockBuyAndSellMaxKTransactionsAllowed {

    public static void main(String[] args) {
        int prices[] = { 10, 22, 5, 80 };
        int k = 2;
        System.out.println(maxProfit(prices, k));
    }

    static int maxProfit(int prices[], int k) {
        // code here
        int N = prices.length;
        int dp[][] = new int[N + 1][2 * k + 1];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < 2 * k; j++) {

                if (j % 2 == 0) {
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][j + 1],
                            dp[i + 1][j]);
                } else {
                    dp[i][j] = Math.max(prices[i] + dp[i + 1][j + 1],
                            dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
