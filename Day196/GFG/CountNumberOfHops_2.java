//GFG
//Count number of hops - Store the fixed states 
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class CountNumberOfHops_2 {

    public static void main(String[] args) {
        int N = 4;
        System.out.println(countWays(N));
    }

    // Function to count the number of ways in which frog can reach the top.
    static long mod = 1000000007;

    static long countWays(int n) {

        long a = 1;
        long b = 2;
        long c = 4;
        if (n == 1)
            return a;
        if (n == 2)
            return b;
        if (n == 3)
            return c;

        long d = 0;
        for (int i = 4; i <= n; i++) {
            d = (((a % mod + b % mod) % mod) % mod + c % mod) % mod;
            a = b % mod;
            b = c % mod;
            c = d % mod;
        }

        return d % mod;
    }
}
