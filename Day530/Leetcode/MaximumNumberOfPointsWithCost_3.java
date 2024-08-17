//Leetcode
//1937. Maximum Number of Points with Cost - Improving the Space Complexity of previous approach 
//Time complexity: O(M*N)
//Space complexity: O(N)

package Leetcode;

public class MaximumNumberOfPointsWithCost_3 {

    public static void main(String[] args) {
        int[][] points = { { 1, 2, 3 }, { 1, 5, 1 }, { 3, 1, 1 } };
        System.out.println(maxPoints(points));
    }

    public static long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;

        long[] dp = new long[cols];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++)
                dp[j] += points[i][j];

            // left to right pass
            for (int j = 1; j < cols; j++)
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);

            // right to left pass
            for (int j = cols - 2; j >= 0; j--)
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
        }

        long maxPoints = 0;
        for (int j = 0; j < cols; j++)
            maxPoints = Math.max(maxPoints, dp[j]);
        return maxPoints;
    }
}
