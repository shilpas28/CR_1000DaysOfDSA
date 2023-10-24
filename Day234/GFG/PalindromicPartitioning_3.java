//GFG
//Palindromic Partitioning - Tabulation/Bottom up method 
//Time complexity: O(N^2) - There are a total of N states and inside each state a loop of size N(apparently) is running.
//Space complexity: O(N) - O(N) is for the dp array we have used.

package GFG;

public class PalindromicPartitioning_3 {

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromicPartition(str));
    }

    static int palindromicPartition(String str) {
        // code here
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, str)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
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
