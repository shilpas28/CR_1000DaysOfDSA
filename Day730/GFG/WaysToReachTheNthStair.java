//GFG
//Ways to Reach the n'th Stair - Recursion - Not accepted as TLE 
//Time complexity: O(2^N), where N is the given number of stairs. The number of recursive calls roughly follows a Fibonacci-like 
//sequence, where climbStairs(n) is approximately 2^N. This is because each call branches into two more calls, leading to an exponential 
//growth in the number of calls.
//Space complexity: O(N) - This is because the maximum depth of the recursion stack can go up to n, due to the linear nature of the 
//stack usage relative to the input size n.

public class WaysToReachTheNthStair {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
    }

    static int countWays(int n) {
        // your code here
        // Base case
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        // Taking 1 step at a time
        int oneStep = countWays(n - 1);
        // Taking 2 steps at a time
        int twoSteps = countWays(n - 2);
        // Return total ways
        return oneStep + twoSteps;
    }
}
