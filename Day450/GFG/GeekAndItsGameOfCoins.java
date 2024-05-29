//GFG
//Geek and its Game of Coins
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class GeekAndItsGameOfCoins {

    public static void main(String[] args) {
        int n = 5, x = 3, y = 4;
        System.out.println(findWinner(n, x, y));
    }

    public static int findWinner(int n, int x, int y) {
        // code here
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i - 1 >= 0 && dp[i - 1] == 0)
                dp[i] = 1;
            else if (i - x >= 0 && dp[i - x] == 0)
                dp[i] = 1;
            else if (i - y >= 0 && dp[i - y] == 0)
                dp[i] = 1;
            else
                dp[i] = 0;
        }
        return dp[n];
    }
}
