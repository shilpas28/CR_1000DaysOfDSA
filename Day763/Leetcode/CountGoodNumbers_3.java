//Leetcode
//1922. Count Good Numbers - Optimal (Without Recursion)
//Time complexity: O(logN)
//Space complexity: O(1)

public class CountGoodNumbers_3 {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countGoodNumbers(n));
    }

    static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        long good = n % 2 == 0 ? 1 : 5;
        for (long i = n / 2, x = 4 * 5; i > 0; i /= 2, x = x * x % MOD) {
            if (i % 2 != 0) {
                good = good * x % MOD;
            }
        }
        return (int) good;
    }
}
