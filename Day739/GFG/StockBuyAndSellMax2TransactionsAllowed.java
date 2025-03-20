//GFG
//Stock Buy and Sell – Max 2 Transactions Allowed
//Time complexity: O(N)
//Space complexity: O(N)

public class StockBuyAndSellMax2TransactionsAllowed {

    public static void main(String[] args) {
        int[] prices = { 10, 22, 5, 75, 65, 80 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // code here
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
