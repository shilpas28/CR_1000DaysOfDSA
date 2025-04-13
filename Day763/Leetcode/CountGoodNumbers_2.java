//Leetcode
//1922. Count Good Numbers - Optimal (With Recursion)
//Time complexity: O(logN)
//Space complexity: O(1)

public class CountGoodNumbers_2 {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countGoodNumbers(n));
    }

    static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        return (int) (countGood(n / 2, 4 * 5) * (n % 2 == 0 ? 1 : 5) % MOD);
    }

    static long countGood(long power, long x) {
        if (power == 0) {
            return 1;
        } else if (power % 2 == 0) {
            return countGood(power / 2, x * x % MOD);
        }
        return x * countGood(power - 1, x) % MOD;
    }
}
