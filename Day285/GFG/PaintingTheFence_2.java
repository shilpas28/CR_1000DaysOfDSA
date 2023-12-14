//GFG
//Painting the Fence - Better Method
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

public class PaintingTheFence_2 {

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        System.out.println(countWays(n, k));
    }

    static long countWays(int n, int k) {
        // code here.
        long total = k, same = 0, diff = k, mod = (long) 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (total % mod * (k - 1) % mod) % mod;
            total = (same + diff) % mod;
        }
        return total;
    }
}
