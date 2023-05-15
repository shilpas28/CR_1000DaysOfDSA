//GFG
//Count Total Setbits
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class CountTotalSetbits {

    public static void main(String[] args) {
        int N = 3;
        System.out.println(countBits(N));
    }

    public static long countBits(long N) {
        // code here
        if (N == 0)
            return 0;

        long x = larPowOf2(N);
        long y = x * (1 << (x - 1));
        long z = N - (1 << x);
        return y + z + 1 + countBits(z);
    }

    static long larPowOf2(long n) {
        long x = 0;
        while ((1 << x) <= n)
            x++;

        return x - 1;
    }
}
