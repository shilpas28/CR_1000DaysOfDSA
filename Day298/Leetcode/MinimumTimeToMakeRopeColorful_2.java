//Leetcode
//1578. Minimum Time to Make Rope Colorful - Tabulation/Bottom Up
//Time complexity: O(n)
//Space complexity: O(n)  

package Leetcode;

import java.util.Arrays;

public class MinimumTimeToMakeRopeColorful_2 {

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = { 1, 2, 3, 4, 5 };
        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        char previousColor = 'A';
        int previousTime = 0;

        for (int i = 1; i <= n; i++) {
            if (colors.charAt(i - 1) == previousColor) {
                dp[i] = dp[i - 1] + Math.min(neededTime[i - 1], previousTime);
                previousTime = Math.max(neededTime[i - 1], previousTime);
            } else {
                dp[i] = dp[i - 1];
                previousColor = colors.charAt(i - 1);
                previousTime = neededTime[i - 1];
            }
        }

        return dp[n];
    }
}
