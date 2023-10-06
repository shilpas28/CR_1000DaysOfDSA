//Leetcode 
//343. Integer Break - using Tabulation/Bottom up method
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class IntegerBreak_3 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        
        for (int i = 3; i <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
        return dp[n];
    }
}
