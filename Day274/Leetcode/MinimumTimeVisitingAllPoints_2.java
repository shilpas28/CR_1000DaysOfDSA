//Leetcode
//1266. Minimum Time Visiting All Points
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumTimeVisitingAllPoints_2 {

    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 3, 4 }, { -1, 0 } };
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int a = points[i + 1][0];
            int b = points[i + 1][1];

            time += Math.max(Math.abs(a - x), Math.abs(b - y));
        }
        return time;
    }
}
