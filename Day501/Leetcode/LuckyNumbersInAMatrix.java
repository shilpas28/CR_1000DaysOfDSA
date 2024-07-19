//Leetcode
//1380. Lucky Numbers in a Matrix
//Time complexity: O(m*n)
//Space complexity: O(m) 

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minIndex = 0;
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minIndex = j;
                }
            }
            boolean isTrue = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][minIndex] < matrix[j][minIndex]) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue)
                arr.add(matrix[i][minIndex]);
        }
        return arr;
    }
}
