//Leetcode
//2463. Minimum Total Distance Traveled
//Time complexity: O((M^2)*N)
//Space complexity: O(M*N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTotalDistanceTraveled {

    public static void main(String[] args) {
        List<Integer> robot = new ArrayList<>();
        robot.add(0);
        robot.add(4);
        robot.add(6);
        int[][] factory = { { 2, 2 }, { 6, 2 } };
        System.out.println(minimumTotalDistance(robot, factory));
    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int m = robot.size(), n = factory.length;
        long[][] dp = new long[m + 1][n + 1];
        Arrays.sort(factory, (f1, f2) -> f1[0] - f2[0]);
        Collections.sort(robot);
        for (int i = 1; i <= m; i++)
            dp[i][0] = 200000000001L; // impossible to move robots when there is no factory
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j];
                long v = 0;
                for (int k = i; k >= 0 && k > i - factory[j][1]; k--) {
                    v += Math.abs(factory[j][0] - robot.get(k));
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[k][j] + v);
                }
            }
        }
        return dp[m][n];
    }
}
