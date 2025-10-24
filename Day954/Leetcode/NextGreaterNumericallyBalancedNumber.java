//Leetcode
//2048. Next Greater Numerically Balanced Number - Enumeration
//Time complexity: O(C−n)
//Space complexity: O(1)

package Leetcode;

public class NextGreaterNumericallyBalancedNumber {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(nextBeautifulNumber(n));
    }

    public static int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; ++i) {
            if (isBalance(i)) {
                return i;
            }
        }
        return -1;
    }

    static boolean isBalance(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int d = 0; d < 10; ++d) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }
}
