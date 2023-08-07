//GFG
//Solve the Sudoku
//Time complexity: O(9^(N*N))
//Space complexity: O(N*N)

package GFG;

public class SolveTheSudoku {

    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        SolveSudoku(grid);
        printGrid(grid);
    }

    // Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][]) {
        // add your code here
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(k, grid, i, j)) {
                            grid[i][j] = k;
                            if (SolveSudoku(grid) == true)
                                return true;
                            else
                                grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Function to find a solved Sudoku.
    static boolean isValid(int num, int[][] grid, int row, int col) {
        for (int i = 0; i < 9; i++)
            if (grid[row][i] == num)
                return false;
        for (int i = 0; i < 9; i++)
            if (grid[i][col] == num)
                return false;
        int rr = row - row % 3, cc = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[rr + i][cc + j] == num)
                    return false;
            }
        }
        return true;
    }

    // Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        // add your code here
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(grid[i][j] + " ");
        }
    }
}
