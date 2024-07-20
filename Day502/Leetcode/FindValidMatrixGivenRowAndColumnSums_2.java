//Leetcode
//1605. Find Valid Matrix Given Row and Column Sums
//Time complexity: O(mn) for initializing output and O(m + n) for process
//Space complexity: O(mn)

public class FindValidMatrixGivenRowAndColumnSums_2 {

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
        int m = rowSum.length, n = colSum.length, i = 0, j = 0, a;
        int[][] A = new int[m][n];
        while (i < m && j < n) {
            a = A[i][j] = Math.min(rowSum[i], colSum[j]);
            if ((rowSum[i] -= a) == 0)
                ++i;
            if ((colSum[j] -= a) == 0)
                ++j;
        }
        return A;
    }
}
