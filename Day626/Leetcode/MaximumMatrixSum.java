//Leetcode
//1975. Maximum Matrix Sum
//Time complexity: O(m*n)
//Space complexity: O(1) 

public class MaximumMatrixSum {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { -1, -2, -3 }, { 1, 2, 3 } };
        System.out.println(maxMatrixSum(matrix));
    }

    public static long maxMatrixSum(int[][] matrix) {
        long maxSum = 0;
        int negCnt = 0;
        int minNegVal = Integer.MAX_VALUE;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(matrix[i][j]);
                minNegVal = Math.min(minNegVal, val);
                maxSum += val;
                if (matrix[i][j] < 0) // Negative
                    negCnt++;
            }
        }

        if (negCnt % 2 == 0)
            return maxSum;
        else
            return maxSum - 2 * minNegVal;
    }
}
