//Leetcode
//452. Minimum Number of Arrows to Burst Balloons
//Time complexity: O(nlogn)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}
