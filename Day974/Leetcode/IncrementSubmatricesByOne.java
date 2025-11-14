//Leetcode
//2536. Increment Submatrices by One - Brute force approach
//Time complexity: O(m * n^2)
//Space complexity: O(n^2)

public class IncrementSubmatricesByOne {

    public static void main(String[] args) {
        int n = 3;
        int[][] queries = { { 1, 1, 2, 2 }, { 0, 0, 1, 1 } };
        int[][] res = rangeAddQueries(n, queries);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] a = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0], r2 = q[2]; // row1, row2
            int c1 = q[1], c2 = q[3]; // col1, col2
            // iterate over the matrix
            // with corners row1, col1 and row2, col2
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    a[i][j]++; // increment
                }
            }
        }

        return a; // return the matrix
    }
}
