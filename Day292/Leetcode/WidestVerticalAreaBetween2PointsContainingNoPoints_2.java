//Leetcode
//1637. Widest Vertical Area Between Two Points Containing No Points
//Time complexity: O(nlogn)
//Space complexity: O(n)

package Leetcode;

import java.util.Set;
import java.util.TreeSet;

public class WidestVerticalAreaBetween2PointsContainingNoPoints_2 {

    public static void main(String[] args) {
        int[][] points = { { 3, 1 }, { 9, 0 }, { 1, 0 }, { 1, 4 }, { 5, 3 }, { 8, 8 } };
        System.out.println(maxWidthOfVerticalArea(points));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> xCoordinates = new TreeSet<>();

        for (int[] point : points) {
            xCoordinates.add(point[0]);
        }

        int maxDiff = 0;
        Integer prevX = null;

        for (int x : xCoordinates) {
            if (prevX != null) {
                maxDiff = Math.max(maxDiff, x - prevX);
            }
            prevX = x;
        }

        return maxDiff;
    }
}
