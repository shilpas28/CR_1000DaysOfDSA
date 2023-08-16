//GFG
//Nth catalan number
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

public class NthCatalanNumber {

    public static void main(String[] args) {
        int N = 5;
        System.out.println(findCatalan(N));
    }

    static int m = 1000000007;
    public static int findCatalan(int n) {
        // code here
        long dp[] = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++)
                dp[i] = (dp[i] + (dp[j] * dp[i - j - 1]) % m) % m;
        }
        return (int) dp[n];
    }
}
