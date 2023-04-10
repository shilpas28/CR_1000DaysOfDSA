//GFG
//Maximum Intersecting Lines - Greedy Approach
//Time complexity: O(N*log(N))
//Space complexity: O(N)

import java.util.Arrays;

public class MaximumIntersectingLines_1 {
    public static void main(String[] args) {
        int N = 4;
        int lines[][] = { { 1, 3 }, { 2, 3 }, { 1, 2 }, { 4, 4 } };
        System.out.println(maxIntersections(lines, N));
    }

    public static int maxIntersections(int[][] lines, int N) {
        // Code here
        int[] slines = new int[N];
        int[] elines = new int[N];

        for (int i = 0; i < N; i++) {
            slines[i] = lines[i][0];
            elines[i] = lines[i][1];
        }

        Arrays.sort(slines);
        Arrays.sort(elines);
        int i = 0;
        int j = 0;
        int intersections = 0;
        int finalAns = Integer.MIN_VALUE;

        while (i < N && j < N) {
            if (slines[i] <= elines[j]) {
                intersections++;
                finalAns = Math.max(finalAns, intersections);
                i++;
            } else {
                intersections--;
                j++;
            }
        }
        return finalAns;
    }
}
