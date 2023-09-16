//GFG
//Count number of hops - using DP
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class CountNumberOfHops {

    public static void main(String[] args) {
        int N = 4;
        System.out.println(countWays(N));
    }

    // Function to count the number of ways in which frog can reach the top.
    static long mod = 1000000007;
    static long countWays(int n) {
        // add your code here
        long dp[] = new long[n];

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i < n; i++) {
            dp[i] = (((dp[i - 1] % mod + dp[i - 2] % mod) % mod) % mod + dp[i - 3] % mod) % mod;
        }

        return dp[n - 1];
    }
}
