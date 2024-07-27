//GFG
//Form a palindrome - Memoization 
//Time complexity: O(N^2)
//Space complexity: O(N^2)

public class FormAPalindrome {

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(countMin(str));
    }

    static int countMin(String str) {
        // code here
        int n = str.length();
        Integer dp[][] = new Integer[n][n];
        return solve(0, n - 1, dp, str);
    }

    static int solve(int i, int j, Integer dp[][], String s) {
        if (i >= j)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = solve(i + 1, j - 1, dp, s);
        return dp[i][j] = Math.min(solve(i + 1, j, dp, s), solve(i, j - 1, dp, s)) + 1;
    }
}
