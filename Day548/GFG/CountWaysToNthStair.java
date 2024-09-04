//GFG
//Count ways to N'th Stair(Order does not matter)
//Time complexity: O(n)
//Space complexity: O(n)

public class CountWaysToNthStair {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(nthStair(n));
    }

    public static long nthStair(int n) {
        // Code here
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}
