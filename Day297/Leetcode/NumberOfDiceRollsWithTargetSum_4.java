//Leetcode
//1155. Number of Dice Rolls With Target Sum - Space Optimization
//Time complexity: 
//Space complexity: 

package Leetcode;

public class NumberOfDiceRollsWithTargetSum_4 {

    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        System.out.println(numRollsToTarget(n, k, target));
    }

    static int mod = 1_000_000_007;

    public static int numRollsToTarget(int n, int k, int target) {
        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = 0;
                for (int l = 1; l <= k; l++) {
                    if (j >= l) {
                        dp[j] = (dp[j] + dp[j - l]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }
        return (int) dp[target];
    }
}
