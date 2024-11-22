//Leetcode
//1072. Flip Columns For Maximum Number of Equal Rows - HashMap 
//Time complexity: O(n*m)
//Space complexity: O(m)

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows_2 {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1 }, { 1, 1 } };
        System.out.println(maxEqualRowsAfterFlips(matrix));
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patFreq = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row)
                    pattern.append(bit);
            } else {
                for (int bit : row)
                    pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }
        return Collections.max(patFreq.values());
    }
}
