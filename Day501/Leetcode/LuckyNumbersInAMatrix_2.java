//Leetcode
//1380. Lucky Numbers in a Matrix - Almost same logic as first brute force solution but slightly different implementation
//Time complexity: O(m*n)
//Space complexity: O(m)

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix_2 {

    public static void main(String[] args) {
        int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> h = new ArrayList<>();
        int minIndex = 0;

        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][minIndex] > max) {
                    max = matrix[j][minIndex];
                }
            }
            if (max == min) {
                h.add(max);
            }
        }
        return h;
    }
}
