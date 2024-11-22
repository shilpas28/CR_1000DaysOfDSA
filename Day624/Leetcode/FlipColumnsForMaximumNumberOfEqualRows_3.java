//Leetcode
//1072. Flip Columns For Maximum Number of Equal Rows - Bit Manipulation
//Time complexity: O(n*m)
//Space complexity: O(m)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows_3 {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1 }, { 1, 1 } };
        System.out.println(maxEqualRowsAfterFlips(matrix));
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            if (matrix[i][m - 1] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] ^= matrix[i][m - 1];
                }
            }
            int count = map.merge(Arrays.hashCode(matrix[i]), 1, Integer::sum);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
