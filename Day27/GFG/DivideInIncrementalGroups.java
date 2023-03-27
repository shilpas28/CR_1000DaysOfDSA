//GFG
//Divide in Incremental Groups
//Time complexity: O(N2*K)
//Space complexity: O(N2*K)

package GFG;

import java.util.Arrays;

public class DivideInIncrementalGroups {

    public static void main(String[] args) {
        int N = 8;
        int K = 4;
        System.out.println(countWaystoDivide(N, K));
    }

    static int mod = 1000000007;
    static int dp[][][];

    public static int countWaystoDivide(int N, int K) {
        // Code here
        dp = new int[N + 1][K + 1][N + 1];
        for (int x[][] : dp) {
            for (int y[] : x)
                Arrays.fill(y, -1);
        }
        return solve(N, K, N);
    }

    static int solve(int n, int k, int last) {
        // base case
        if (k == 0) {
            return (n == 0) ? 1 : 0;
        }
        if (dp[n][k][last] != -1) {
            return dp[n][k][last];
        }
        int answer = 0;
        // try all possible sizes of Kth group
        for (int s = 1; s <= Math.min(n, last); s++) {
            answer += solve(n - s, k - 1, s);
            answer = answer % mod;
        }
        return dp[n][k][last] = answer;
    }

}
