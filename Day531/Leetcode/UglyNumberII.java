//Leetcode
//264. Ugly Number II - Not accepted as TLE
//Time complexity: O(K) where K is the nth ugly number
//Space complexity: O(1)

public class UglyNumberII {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        int i = 0, count = 0;
        while (count < n) {
            int isUgly = i + 1;
            for (int factor : new int[] { 2, 3, 5 }) {
                isUgly = keepsOnDividingUntilPossible(isUgly, factor);
            }
            if (isUgly == 1) {
                count++;
            }
            i++;
        }
        return i;
    }

    public static int keepsOnDividingUntilPossible(int dividend, int divisor) {
        while (dividend % divisor == 0) {
            dividend /= divisor;
        }
        return dividend;
    }
}
