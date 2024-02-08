//Leetcode - Not accepted as TLE
//279. Perfect Squares - Brute Force (Recursion)
//Time complexity:
//Space complexity: 

package Leetcode;

public class PerfectSquares {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        if (n < 4)
            return n;

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + numSquares(n - square));
        }
        return ans;
    }
}
