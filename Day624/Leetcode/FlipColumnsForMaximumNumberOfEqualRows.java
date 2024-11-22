//Leetcode
//1072. Flip Columns For Maximum Number of Equal Rows - HashMap 
//Time complexity: O(m*n)
//Space complexity: O(m*n)

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1 }, { 1, 1 } };
        System.out.println(maxEqualRowsAfterFlips(matrix));
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> count = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder key = new StringBuilder();

            if (row[0] == 1) {
                for (int n : row)
                    key.append(n == 0 ? 1 : 0);
            } else {
                for (int n : row)
                    key.append(n);
            }
            count.merge(key.toString(), 1, Integer::sum);
        }
        return Collections.max(count.values());
    }
}
