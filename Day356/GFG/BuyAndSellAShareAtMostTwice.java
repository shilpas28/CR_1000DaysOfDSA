//GFG
//Buy and Sell a Share at most twice
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

public class BuyAndSellAShareAtMostTwice {

    public static void main(String[] args) {
        int n = 6;
        int prices[] = { 10, 22, 5, 75, 65, 80 };
        System.out.println(maxProfit(n, prices));
    }

    public static int maxProfit(int n, int[] price) {
        // code here
        int dp[][] = new int[n + 1][5];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int trans = 3; trans >= 0; trans--) {
                int profit = 0;
                if (trans % 2 == 0) {
                    profit = Math.max(-price[ind] + dp[ind + 1][trans + 1], dp[ind + 1][trans]);
                } else {
                    profit = Math.max(price[ind] + dp[ind + 1][trans + 1], dp[ind + 1][trans]);
                }
                dp[ind][trans] = profit;
            }
        }
        return dp[0][0];
    }
}
