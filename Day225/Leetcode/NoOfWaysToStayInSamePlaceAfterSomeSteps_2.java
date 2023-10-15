//Leetcode
//1269. Number of Ways to Stay in the Same Place After Some Steps - Memoization/Top down
//Time complexity: O(steps∗arrLen) because for each combination of steps and index, you make three recursive calls, 
//and there are steps * arrLen unique combinations.
//Space complexity: O(steps∗arrLen) for the memoization table.

package Leetcode;

import java.util.Arrays;

public class NoOfWaysToStayInSamePlaceAfterSomeSteps_2 {

    public static void main(String[] args) {
        int steps = 3, arrLen = 2;
        System.out.println(numWays(steps, arrLen));
    }

    public static int numWays(int steps, int arrLen) {

        final int MOD = 1000000007;
        int[][] memo = new int[steps + 1][Math.min(arrLen, steps) + 1];

        for (int i = 0; i <= steps; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(steps, 0, arrLen, MOD, memo);
    }

    static int dp(int step, int index, int arrLen, int MOD, int[][] memo) {
        if (step == 0) {
            return (index == 0) ? 1 : 0;
        }
        if (step < 0 || index < 0 || index >= arrLen) {
            return 0;
        }
        if (memo[step][index] != -1) {
            return memo[step][index];
        }

        int ways = dp(step - 1, index, arrLen, MOD, memo) % MOD;
        ways += dp(step - 1, index - 1, arrLen, MOD, memo) % MOD;
        ways += dp(step - 1, index + 1, arrLen, MOD, memo) % MOD;

        memo[step][index] = ways % MOD;
        return ways % MOD;
    }
}
