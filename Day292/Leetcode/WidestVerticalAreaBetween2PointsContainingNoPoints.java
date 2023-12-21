//Leetcode
//1637. Widest Vertical Area Between Two Points Containing No Points - Sorting
//Time complexity: O(nlogn)
//Space complexity: O(logn)

package Leetcode;

import java.util.Arrays;

public class WidestVerticalAreaBetween2PointsContainingNoPoints {

    public static void main(String[] args) {
        int[][] points = { { 3, 1 }, { 9, 0 }, { 1, 0 }, { 1, 4 }, { 5, 3 }, { 8, 8 } };
        System.out.println(maxWidthOfVerticalArea(points));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int diff = 0;
        for (int i = 1; i < points.length; i++) {
            diff = Math.max(diff, points[i][0] - points[i - 1][0]);
        }
        return diff;
    }
}
