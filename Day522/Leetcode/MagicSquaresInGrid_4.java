//Leetcode
//840. Magic Squares In Grid
//Time complexity: O(R*C)
//Space complexity: O(1)

public class MagicSquaresInGrid_4 {

    public static void main(String[] args) {
        int[][] grid = { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } };
        System.out.println(numMagicSquaresInside(grid));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isMagicSquare(int[][] grid, int row, int col) {
        int usedNumbers = 0;
        int[] rowSums = new int[3];
        int[] colSums = new int[3];
        int diag1 = 0, diag2 = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];

                // Check if number is between 1 and 9
                if (num < 1 || num > 9)
                    return false;

                // Check for duplicates using bit manipulation
                int bit = 1 << num;
                if ((usedNumbers & bit) != 0)
                    return false;
                usedNumbers |= bit;

                // Update sums
                rowSums[i] += num;
                colSums[j] += num;
                if (i == j)
                    diag1 += num;
                if (i + j == 2)
                    diag2 += num;
            }
        }

        // Check if all sums are equal
        int sum = rowSums[0];
        if (diag1 != sum || diag2 != sum)
            return false;
        for (int i = 0; i < 3; i++) {
            if (rowSums[i] != sum || colSums[i] != sum)
                return false;
        }
        return true;
    }
}
