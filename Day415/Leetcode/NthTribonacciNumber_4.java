//Leetcode
//1137. N-th Tribonacci Number - Space-Optimized Iterative Approach
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NthTribonacciNumber_4 {

    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int a = 0, b = 1, c = 1;
        int nextTrib;

        for (int i = 3; i <= n; i++) {
            nextTrib = a + b + c;
            a = b;
            b = c;
            c = nextTrib;
        }

        return c;
    }
}
