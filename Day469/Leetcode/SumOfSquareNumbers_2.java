//Leetcode
//633. Sum of Square Numbers
//Time complexity: O(sqrt(c))  because we iterate from 0 to the integer square root of c and perform constant-time 
//operations within the loop.
//Space complexity: O(1) as we only use a constant amount of extra space.

package Leetcode;

public class SumOfSquareNumbers_2 {

    public static void main(String[] args) {
        int c = 5;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) { // Iterate through all possible values of `a`
            double b = Math.sqrt(c - a * a); // Compute `b` as the square root of `c - a^2`
            if (b == (int) b) { // Check if `b` is an integer
                return true; // If `b` is an integer, return true
            }
        }
        return false; // If no such pair `(a, b)` is found, return false
    }
}
