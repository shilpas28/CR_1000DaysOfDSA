//GFG
//Painting the Fence - Brute Force 
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

public class PaintingTheFence {

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        System.out.println(countWays(n, k));
    }

    static long countWays(int n, int k) {
        // code here.
        if (n == 1)
            return k;
        if (n == 2)
            return k + k * (k - 1) % 1000000007;

        long mod = 1000000007;
        long same = k;
        long diff = (k % mod * (k - 1) % mod) % mod;
        long total = (same % mod + diff % mod) % mod;

        for (long i = 3; i <= n; i++) {
            same = diff % mod;
            diff = (total % mod * (k - 1) % mod) % mod;
            total = (same % mod + diff % mod) % mod;
        }

        return total;
    }
}
