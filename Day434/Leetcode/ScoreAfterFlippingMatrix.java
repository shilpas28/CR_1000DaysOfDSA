//Leetcode
//861. Score After Flipping Matrix
//Time complexity: O(M*N)
//Space complexity: O(1)

package Leetcode;

public class ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };
        System.out.println(matrixScore(grid));
    }

    public static int matrixScore(int[][] grid) {
        
        int N = grid.length,
                M = grid[0].length;
        // Optimize, step1: flip all rows starting with a zero
        for (int i = 0; i < N; ++i) {
            if (grid[i][0] == 0)
                flipRow(grid, i);
        }
        // Optimize, step 2: flip all columns where the number of zeros is larger than
        // the number of ones
        for (int col = 1; col < M; ++col) {
            int sumCol = 0;
            for (int i = 0; i < N; ++i)
                sumCol += grid[i][col];

            if (sumCol * 2 < N)
                flipCol(grid, col);
        }
        // Count final sum
        int total = 0;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                total += grid[i][j] * (1 << (M - j - 1));
        return total;
    }

    static void flipRow(int[][] a, int r) {
        for (int i = 0; i < a[r].length; ++i)
            a[r][i] = (a[r][i] ^ 1);
    }

    static void flipCol(int[][] a, int c) {
        for (int i = 0; i < a.length; ++i)
            a[i][c] = (a[i][c] ^ 1);
    }
}
