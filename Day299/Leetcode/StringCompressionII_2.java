//Leetcode
//1531. String Compression II
//Time complexity: O(kn^2)
//Space complexity: O(kn)

package Leetcode;

import java.util.Arrays;

public class StringCompressionII_2 {

    public static void main(String[] args) {
        String s = "aaabcccd";
        int k = 2;
        System.out.println(getLengthOfOptimalCompression(s, k));
    }

    public static int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0)
                    dp[i][j] = dp[i - 1][j - 1];
                int removed = 0, cnt = 0, p;
                for (p = i; p > 0; p--) {
                    if (s.charAt(p - 1) == s.charAt(i - 1))
                        cnt++;
                    else if (++removed > j)
                        break;
                    dp[i][j] = Math.min(dp[i][j], dp[p - 1][j - removed] + calcLen(cnt));
                }
            }
        }
        return dp[n][k];
    }

    static int calcLen(int len) {
        if (len == 0)
            return 0;
        else if (len == 1)
            return 1;
        else if (len < 10)
            return 2;
        else if (len < 100)
            return 3;
        else
            return 4;
    }
}
