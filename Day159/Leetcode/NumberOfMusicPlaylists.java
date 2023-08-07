//Leetcode
//920. Number of Music Playlists
//Time complexity: O((L-K)(N-K)) where L = goal, N = n and K = k
//Space complexity: O(N*L) where L = goal, N = n and K = k

package Leetcode;

public class NumberOfMusicPlaylists {

    public static void main(String[] args) {
        int n = 3, goal = 3, k = 1;
        System.out.println(numMusicPlaylists(n, goal, k));
    }

    public static int numMusicPlaylists(int n, int goal, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % mod;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - k)) % mod) % mod;
                }
            }
        }
        return (int) dp[goal][n];
    }
}
