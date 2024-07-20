//Leetcode
//1605. Find Valid Matrix Given Row and Column Sums
//Time complexity: O(mn)
//Space complexity: O(mn)

public class FindValidMatrixGivenRowAndColumnSums {

    public static void main(String[] args) {
        int[] rowSum = { 3, 8 };
        int[] colSum = { 4, 7 };
        int[][] res = restoreMatrix(rowSum, colSum);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= A[i][j];
                colSum[j] -= A[i][j];
            }
        }
        return A;
    }
}
