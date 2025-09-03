//Leetcode
//3027. Find the Number of Ways to Place People II
//Time complexity: O(N^2)
//Space complexity: O(1) 

import java.util.Arrays;

public class FindTheNumberOfWaysToPlacePeopleII_2 {

    public static void main(String[] args) {
        int[][] points = { { 6, 2 }, { 4, 4 }, { 2, 6 } };
        System.out.println(numberOfPairs(points));
    }

    public static int numberOfPairs(int[][] points) {
        Arrays.parallelSort(points, (p, q) -> {
            return p[0] == q[0] ? (p[1] - q[1]) : (q[0] - p[0]);
        });
        final int n = points.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int y = Integer.MAX_VALUE, yi = points[i][1];
            for (int j = i + 1; j < n; j++) {
                final int yj = points[j][1];
                if (yj >= yi && y > yj) {// P[j] cannot be in between
                    ans++;
                    y = yj;
                    if (yi == yj)
                        break;
                }
            }
        }
        return ans;
    }
}
