//Leetcode
//2661. First Completely Painted Row or Column - Brute Force
//Time complexity: O( (k*(m+n)) + (m*n) )
//Space complexity: O(m*n)

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class FirstCompletelyPaintedRowOrColumn {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2 };
        int[][] mat = { { 1, 4 }, { 2, 3 } };
        System.out.println(firstCompleteIndex(arr, mat));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int numRows = mat.length, numCols = mat[0].length;
        Map<Integer, Pair<Integer, Integer>> numToPos = new HashMap<>();
        // Populate the numToPos map by iterating over the matrix
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int value = mat[row][col];
                numToPos.put(value, new Pair<>(row, col));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            Pair<Integer, Integer> pos = numToPos.get(num);
            int row = pos.getKey();
            int col = pos.getValue();
            mat[row][col] = -mat[row][col]; // mark as seen
            // Check if the row or column is completely painted
            if (checkRow(row, mat) || checkColumn(col, mat)) {
                return i;
            }
        }
        return -1; // This line will never be reached as per the problem statement
    }

    static boolean checkRow(int row, int[][] mat) {
        // Return true if row is completely seen
        for (int col = 0; col < mat[0].length; col++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }

    static boolean checkColumn(int col, int[][] mat) {
        // Return true if col is completely seen
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }
}
