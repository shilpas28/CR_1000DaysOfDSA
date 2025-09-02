//Leetcode
//3025. Find the Number of Ways to Place People I
//Time complexity: O(N^2logN)
//Space complexity: O(N) 

import java.util.Arrays;
import java.util.TreeSet;

public class FindTheNumberOfWaysToPlacePeopleI_2 {

    public static void main(String[] args) {
        int[][] points = { { 6, 2 }, { 4, 4 }, { 2, 6 } };
        System.out.println(numberOfPairs(points));
    }

    public static int numberOfPairs(int[][] points) {
        int n = points.length;
        // Sort: x asc, y desc
        Arrays.sort(points, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        int count = 0;
        // For each left point (p1)
        for (int i = 0; i < n; i++) {
            TreeSet<Integer> ySeen = new TreeSet<>();
            int[] p1 = points[i];

            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                if (p1[0] <= p2[0] && p1[1] >= p2[1]) {
                    // Find if any y in ySeen lies between [p2.y, p1.y]
                    Integer yInRange = ySeen.ceiling(p2[1]); // smallest >= p2.y
                    if (yInRange == null || yInRange > p1[1]) {
                        count++; // valid pair
                    }
                }
                // Insert p2.y for future checks
                ySeen.add(p2[1]);
            }
        }
        return count;
    }
}
