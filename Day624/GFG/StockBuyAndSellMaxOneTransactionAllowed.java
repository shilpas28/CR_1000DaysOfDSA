//GFG
//Stock Buy and Sell – Max one Transaction Allowed
//Time complexity: O(N)
//Space complexity: O(1)

public class StockBuyAndSellMaxOneTransactionAllowed {

    public static void main(String[] args) {
        int prices[] = { 7, 10, 1, 3, 6, 9, 2 };
        System.out.println(maximumProfit(prices));
    }

    public static int maximumProfit(int prices[]) {
        // Code here
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (buyPrice > price) {
                buyPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            }
        }
        return maxProfit;
    }
}
