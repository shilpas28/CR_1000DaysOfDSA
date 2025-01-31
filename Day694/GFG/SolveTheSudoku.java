//GFG
//Solve the Sudoku
//Time complexity: O(9 ^ (n * n))
//Space complexity: O(n) 

package GFG;

public class SolveTheSudoku {

    public static void main(String[] args) {
        int mat[][] = { { 3, 0, 6, 5, 7, 8, 4, 0, 0 }, { 5, 6, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 8, 6, 3, 0, 0 } };

        solveSudoku(mat);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        solver(mat);
    }

    static boolean solver(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] == 0) {

                    for (int c = 1; c <= 9; c++) {
                        if (isValid(mat, i, j, c)) {
                            mat[i][j] = c;

                            if (solver(mat) == true)
                                return true;
                            else
                                mat[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(int[][] mat, int row, int col, int c) {
        for (int i = 0; i < 9; i++) {
            if (mat[i][col] == c)
                return false;

            if (mat[row][i] == c)
                return false;

            if (mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}
