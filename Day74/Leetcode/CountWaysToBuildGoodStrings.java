//Leetcode:
//2466. Count Ways To Build Good Strings
//Time complexity: O(high)
//Space complexity: O(high)

package Leetcode;

public class CountWaysToBuildGoodStrings {

    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(countGoodStrings(low, high, zero, one));
    }

    public static final int MOD = 1000000007;
    public static int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        for (int len = 1; len <= high; len++) {
            if (len >= zero) {
                dp[len] = dp[len - zero];
            }
            if (len >= one) {
                dp[len] = (dp[len] + dp[len - one]) % MOD;
            }
            if (len >= low) {
                ans = (ans + dp[len]) % MOD;
            }
        }
        return ans;
    }
}
