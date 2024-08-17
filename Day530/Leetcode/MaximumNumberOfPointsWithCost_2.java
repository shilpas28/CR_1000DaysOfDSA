//Leetcode
//1937. Maximum Number of Points with Cost - Improved DP using additional space for left and right passes
//Time complexity: O(M*N)
//Space complexity: O(4N) = O(N)

package Leetcode;

public class MaximumNumberOfPointsWithCost_2 {

    public static void main(String[] args) {
        int[][] points = { { 1, 2, 3 }, { 1, 5, 1 }, { 3, 1, 1 } };
        System.out.println(maxPoints(points));
    }

    public static long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;

        long[] prev = new long[cols];
        for (int i = 0; i < cols; i++)
            prev[i] = points[0][i];

        for (int i = 0; i < rows - 1; i++) {
            long[] left = new long[cols];
            long[] right = new long[cols];
            long curr[] = new long[cols];

            left[0] = prev[0];
            right[cols - 1] = prev[cols - 1];

            for (int j = 1; j < cols; j++)
                left[j] = Math.max(left[j - 1] - 1, prev[j]);

            for (int j = cols - 2; j >= 0; j--)
                right[j] = Math.max(right[j + 1] - 1, prev[j]);

            for (int j = 0; j < cols; j++)
                curr[j] = points[i + 1][j] + Math.max(left[j], right[j]);

            prev = curr;
        }

        long maxPoints = 0;
        for (int j = 0; j < cols; j++)
            maxPoints = Math.max(maxPoints, prev[j]);
        return maxPoints;
    }
}
