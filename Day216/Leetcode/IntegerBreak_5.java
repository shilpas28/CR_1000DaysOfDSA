//Leetcode 
//343. Integer Break - Optimized solution
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class IntegerBreak_5 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        else if (n % 3 == 1)
            return (int) (Math.pow(3, n / 3 - 1)) * 4;
        else if (n % 3 == 2)
            return 2 * ((int) Math.pow(3, n / 3));
        else
            return (int) Math.pow(3, n / 3);
    }
}
