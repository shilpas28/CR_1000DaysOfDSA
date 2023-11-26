//Leetcode
//1727. Largest Submatrix With Rearrangements
//Time complexity: O(m * n * log(n)) - Sorting is done for each row.
//Space complexity: O(1) - No additional space is used except for variables.

package Leetcode;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };
        System.out.println(largestSubmatrix(matrix));
    }

    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}
