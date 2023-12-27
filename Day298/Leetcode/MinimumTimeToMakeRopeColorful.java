//Leetcode
//1578. Minimum Time to Make Rope Colorful - Memoization/Top Down 
//Time complexity: O(n)
//Space complexity: O(n)+O(n)

package Leetcode;

import java.util.Arrays;

public class MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = { 1, 2, 3, 4, 5 };
        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return calculateMinCost(n - 1, colors, neededTime, dp, 'A', neededTime[n - 1]);
    }

    static int calculateMinCost(int i, String colorSequence, int[] timeRequired, int[] memo, char previousColor,
            int previousTime) {
        if (i < 0) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        if (colorSequence.charAt(i) == previousColor) {
            return memo[i] = calculateMinCost(i - 1, colorSequence, timeRequired, memo, colorSequence.charAt(i),
                    Math.max(timeRequired[i], previousTime)) + Math.min(timeRequired[i], previousTime);
        } else {
            return memo[i] = calculateMinCost(i - 1, colorSequence, timeRequired, memo, colorSequence.charAt(i),
                    timeRequired[i]);
        }
    }
}
