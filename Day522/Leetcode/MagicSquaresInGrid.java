//Leetcode
//840. Magic Squares In Grid
//Time complexity: O(R*C)
//Space complexity: O(R*C)

public class MagicSquaresInGrid {

    public static void main(String[] args) {
        int[][] grid = { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } };
        System.out.println(numMagicSquaresInside(grid));
    }

    static final int MAGIC_CONSTANT = 15;
    static final int GRID_SIZE = 3;

    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows < GRID_SIZE || cols < GRID_SIZE)
            return 0;

        // Precompute row and column prefix sums
        int[][] rowPrefixSum = new int[rows + 1][cols + 1];
        int[][] colPrefixSum = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                rowPrefixSum[i][j] = rowPrefixSum[i][j - 1] + grid[i - 1][j - 1];
                colPrefixSum[i][j] = colPrefixSum[i - 1][j] + grid[i - 1][j - 1];
            }
        }

        int count = 0;
        for (int i = 0; i <= rows - GRID_SIZE; i++) {
            for (int j = 0; j <= cols - GRID_SIZE; j++) {
                if (isMagicSquare(grid, rowPrefixSum, colPrefixSum, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isMagicSquare(int[][] grid, int[][] rowPrefixSum, int[][] colPrefixSum, int startRow, int startCol) {
        // Check if all numbers are between 1 and 9
        boolean[] used = new boolean[10];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                int num = grid[startRow + i][startCol + j];
                if (num < 1 || num > 9 || used[num])
                    return false;
                used[num] = true;
            }
        }
        // Check row sums
        for (int i = 0; i < GRID_SIZE; i++) {
            int rowSum = rowPrefixSum[startRow + i + 1][startCol + GRID_SIZE]
                    - rowPrefixSum[startRow + i + 1][startCol];
            if (rowSum != MAGIC_CONSTANT)
                return false;
        }
        // Check column sums
        for (int j = 0; j < GRID_SIZE; j++) {
            int colSum = colPrefixSum[startRow + GRID_SIZE][startCol + j + 1]
                    - colPrefixSum[startRow][startCol + j + 1];
            if (colSum != MAGIC_CONSTANT)
                return false;
        }
        // Check main diagonal
        int mainDiagSum = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            mainDiagSum += grid[startRow + i][startCol + i];
        }
        if (mainDiagSum != MAGIC_CONSTANT)
            return false;
        // Check anti-diagonal
        int antiDiagSum = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            antiDiagSum += grid[startRow + i][startCol + GRID_SIZE - 1 - i];
        }
        return antiDiagSum == MAGIC_CONSTANT;
    }
}
