//GFG
//Stock buy and sell II
//Time complexity: O(N)
//Space complexity: O(1)

public class StockBuyAndSellII {

    public static void main(String[] args) {
        int n = 4;
        int[] a = { 3, 4, 1, 5 };
        System.out.println(stockBuyAndSell(n, a));
    }

    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        int buy = -1;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            if (buy == -1) {
                buy = prices[i];
            }
            if (i < n - 1 && prices[i] > prices[i + 1]) {
                profit += (prices[i] - buy);
                buy = -1;
            } else if (buy != -1 && i == n - 1) {
                profit += (prices[i] - buy);
            }
        }
        return profit;
    }
}
