//GFG
//Number of paths
//Time complexity: O(M)
//Space complexity: O(1)

package GFG;

public class NumberOfPaths {

    public static void main(String[] args) {
        int M = 3, N = 3;
        System.out.println(numberOfPaths(M, N));
    }

    static long numberOfPaths(int M, int N) {
        // Code Here
        final int mod = 1000000007;

        int n = M + N - 2;
        int r = M - 1;
        long ans = 1;
        
        // Calculate (n choose r) % mod
        for (int i = 1; i <= r; i++) {
            ans = (ans * (n - i + 1)) % mod;
            ans = (ans * modInverse(i, mod)) % mod;
        }

        return (int) ans;
    }

    static long modInverse(long a, int m) {
        return modPow(a, m - 2, m);
    }

    static long modPow(long base, int exp, int mod) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }

        return result;
    }
}
