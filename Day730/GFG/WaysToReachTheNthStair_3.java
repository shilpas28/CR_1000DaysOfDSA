//GFG
//Ways to Reach the n'th Stair - Tabulation
//Time complexity: O(N), where N is the given number of stairs. This is because we perform a linear number of operations relative 
//to the input size N.
//Space complexity: O(N), an additional array dp of size n + 1 is used to store intermediate results. Hence, the space complexity is O(N).

public class WaysToReachTheNthStair_3 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
    }

    static int countWays(int n) {
        // your code here
        // Declare dp array of size n+1
        int[] dp = new int[n + 1];
        // Insert the values of base conditions
        dp[0] = 1;
        dp[1] = 1;
        // Iterate and update every index of dp array
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // Return the answer
        return dp[n];
    }
}
