//GFG
//Stock Buy and Sell – Multiple Transaction Allowed
//Time complexity: O(N)
//Space complexity: O(1) 

public class StockBuyAndSellMultipleTransactionAllowed {

    public static void main(String[] args) {
        int prices[] = { 100, 180, 260, 310, 40, 535, 695 };
        System.out.println(maximumProfit(prices));
    }

    public static int maximumProfit(int prices[]) {
        // code here
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }
}
