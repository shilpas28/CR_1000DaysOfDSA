//GFG
//Stock Buy and Sell – Max K Transactions Allowed - Space Optimization 
//Time complexity: O(N^2 * k)
//Space complexity: O(k)

public class StockBuyAndSellMaxKTransactionsAllowed_2 {

    public static void main(String[] args) {
        int prices[] = { 10, 22, 5, 80 };
        int k = 2;
        System.out.println(maxProfit(prices, k));
    }

    static int maxProfit(int prices[], int k) {
        // code here
        int N = prices.length;
        int dp[][][] = new int[N + 1][2][k + 1];

        for (int i = N - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int j = k; j >= 1; j--) {

                    if (buy == 1) {
                        dp[i][buy][j] = Math.max(-prices[i] + dp[i + 1][0][j],
                                dp[i + 1][1][j]);
                    } else {
                        dp[i][buy][j] = Math.max(prices[i] + dp[i + 1][1][j - 1],
                                dp[i + 1][0][j]);
                    }

                }
            }
        }
        return dp[0][1][k];
    }
}
