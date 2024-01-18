//Leetcode - Further Space optimization method
//70. Climbing Stairs - very Similar to Fibonaaci except the base case (both are 1s)
//Time complexity: O(N) - We are running a simple iterative loop
//Space complexity: O(1) - We are not using any extra space

package Leetcode;

public class ClimbingStairs_3 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int prev2 = 1;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int cur_i = prev2 + prev;
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }
}
