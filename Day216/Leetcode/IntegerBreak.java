//Leetcode 
//343. Integer Break - using Recursion
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package Leetcode;

public class IntegerBreak {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        return helper(n - 1, n);
    }

    static int helper(int n, int total) {
        if (n <= 1)
            return 1;
        int notpick = helper(n - 1, total);
        int pick = 0;
        if (total >= n)
            pick = n * helper(n, total - n);
        return Math.max(pick, notpick);
    }
}
