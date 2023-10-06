//Leetcode 
//343. Integer Break - Linear solution
//Time complexity: O(N)
//Space complexity: O(1)
 
package Leetcode;

public class IntegerBreak_4 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        if (n == 2 || n == 3)
            return n - 1;
        int res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        return (n * res);
    }
}
