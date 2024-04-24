//Leetcode - Not accepted as TLE
//1137. N-th Tribonacci Number - Recursion
//Time complexity: O(3^N)
//Space complexity: O(N)

package Leetcode;

public class NthTribonacciNumber {

    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
    }
}
