//Leetcode
//342. Power of Four - Brute force method
//Time complexity: O(log(N)^2) - Since we are iterating from 0 to 15 which 15 is log(INT_MAX) to the base of 4 and 
//in each iteration we calculate the power of 4^i which is logarithmic operations so total complexity is O(log(N)^2).
//Space complexity: O(1) - Since we are only storing constant variables.

package Leetcode;

public class PowerOfFour {

    public static void main(String[] args) {
        int n = 18;
        System.out.println(isPowerOfFour(n));
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        if (n % 4 != 0)
            return false;

        return isPowerOfFour(n / 4);
    }
}
