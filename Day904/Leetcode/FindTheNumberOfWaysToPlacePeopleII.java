//Leetcode
//3027. Find the Number of Ways to Place People II - Not accepted as TLE
//Time complexity: O(N^3)
//Space complexity: O(1)

import java.util.Arrays;

public class FindTheNumberOfWaysToPlacePeopleII {

    public static void main(String[] args) {
        int[][] points = { { 6, 2 }, { 4, 4 }, { 2, 6 } };
        System.out.println(numberOfPairs(points));
    }

    public static int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        Arrays.sort(points, (point1, point2) -> point2[1] - point1[1]);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isValidPair(points, points[i], points[j])) {
                    count++;
                }

                if (isValidPair(points, points[j], points[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isValidPair(int[][] points, int[] point1, int[] point2) {
        int upperLeftX = point1[0];
        int upperLeftY = point1[1];
        int lowerRightX = point2[0];
        int lowerRightY = point2[1];

        if (upperLeftX > lowerRightX || upperLeftY < lowerRightY)
            return false;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            // for points[0] & points[1] count all such pairs where
            // no point is present in between them
            if (x >= upperLeftX && x <= lowerRightX && y <= upperLeftY && y >= lowerRightY
                    && !Arrays.equals(point, point1) && !Arrays.equals(point, point2)) {
                return false;
            }
        }
        return true;
    }
}
