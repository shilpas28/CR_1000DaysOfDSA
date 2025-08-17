//Leetcode
//837. New 21 Game
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class New21Game {

    public static void main(String[] args) {
        int n = 10, k = 1, maxPts = 10;
        System.out.println(new21Game(n, k, maxPts));
    }

    public static double new21Game(int n, int k, int maxPts) {
        // Corner cases
        if (k == 0)
            return 1.0;
        if (n >= k - 1 + maxPts)
            return 1.0;

        // dp[i] is the probability of getting point i.
        double[] dp = new double[n + 1];
        Arrays.fill(dp, 0.0);

        double probability = 0.0; // dp of N or less points.
        double windowSum = 1.0; // Sliding required window sum
        dp[0] = 1.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k)
                windowSum += dp[i];
            else
                probability += dp[i];

            if (i >= maxPts)
                windowSum -= dp[i - maxPts];
        }

        return probability;
    }
}
