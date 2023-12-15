//GFG
//Reach the Nth point
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class ReachTheNthPoint_2 {

    public static void main(String[] args) {
        int N = 4;
        System.out.println(nthPoint(N));
    }

    public static int nthPoint(int n) {
        // Code here
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
