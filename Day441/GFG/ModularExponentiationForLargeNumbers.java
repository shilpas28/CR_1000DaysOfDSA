//GFG
//Modular Exponentiation for large numbers
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class ModularExponentiationForLargeNumbers {

    public static void main(String[] args) {
        long x = 2, n = 6, m = 10;
        System.out.println(PowMod(x, n, m));
    }

    public static long PowMod(long x, long n, long m) {
        // Code here
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1)
                ans = (ans * x) % m;
            x = (x * x) % m;
            n /= 2;
        }
        return ans;
    }
}
