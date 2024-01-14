//GFG
//Find duplicate rows in a binary matrix
//Time complexity: O(R * C)
//Space complexity: O(R * C)

package GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateRowsInABinaryMatrix {

    public static void main(String[] args) {
        int R = 4, C = 3;
        int matrix[][] = { { 1, 0, 0 },
                { 1, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 } };
        System.out.println(repeatedRows(matrix, R, C));
    }

    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
        // code here
        Set<Integer> s = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int number = 0;
            for (int j = 0; j < n; j++) {
                number += (matrix[i][j] << j);
            }
            if (!s.contains(number)) {
                s.add(number);
            } else {
                ans.add(i);
            }
        }
        return ans;
    }
}
