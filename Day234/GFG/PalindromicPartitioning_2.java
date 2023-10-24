//GFG
//Palindromic Partitioning - Memoization/Top down method 
//Time complexity: O(N^2) - There are a total of N states and inside each state, a loop of size N(apparently) is running.
//Space complexity: O(N) + Auxiliary stack space O(N) - The first O(N) is for the dp array of size N.

package GFG;

import java.util.Arrays;

public class PalindromicPartitioning_2 {

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromicPartition(str));
    }

    static int palindromicPartition(String str) {
        // code here
        int n = str.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, n, str, dp) - 1;
    }

    static int f(int i, int n, String str, int[] dp) {
        // Base case:
        if (i == n)
            return 0;

        if (dp[i] != -1)
            return dp[i];
        int minCost = Integer.MAX_VALUE;
        // String[i...j]
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + f(j + 1, n, str, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
