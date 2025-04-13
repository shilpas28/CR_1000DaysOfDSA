//Leetcode
//1922. Count Good Numbers - Brute Force - Not accepted as TLE
//Time complexity: O(N)
//Space complexity: O(1)

public class CountGoodNumbers {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countGoodNumbers(n));
    }

    static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        long good = n % 2 == 0 ? 1 : 5;
        for (long i = 0, x = 4 * 5; i < n / 2; ++i) {
            good = good * x % MOD;
        }
        return (int) good;
    }
}
