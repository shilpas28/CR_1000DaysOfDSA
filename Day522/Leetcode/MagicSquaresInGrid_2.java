//Leetcode
//840. Magic Squares In Grid
//Time complexity: O(R*C)
//Space complexity: O(1)

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid_2 {

    public static void main(String[] args) {
        int[][] grid = { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } };
        System.out.println(numMagicSquaresInside(grid));
    }

    static final Set<Integer> magicSquares = new HashSet<>();
    static {
        // Pre-compute all possible 3x3 magic squares
        int[][] base = { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };
        for (int i = 0; i < 8; i++) {
            int[][] rotated = rotate(base);
            magicSquares.add(hash(rotated));
            base = rotated;
            if (i == 3) {
                base = reflect(base);
            }
        }
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isValid(grid, i, j) && magicSquares.contains(hash(extractSubgrid(grid, i, j)))) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean isValid(int[][] grid, int row, int col) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9)
                    return false;
            }
        }
        return true;
    }

    static int[][] extractSubgrid(int[][] grid, int row, int col) {
        int[][] subgrid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subgrid[i][j] = grid[row + i][col + j];
            }
        }
        return subgrid;
    }

    static int hash(int[][] grid) {
        int hash = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hash = hash * 10 + grid[i][j];
            }
        }
        return hash;
    }

    static int[][] rotate(int[][] grid) {
        int[][] rotated = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rotated[j][2 - i] = grid[i][j];
            }
        }
        return rotated;
    }

    static int[][] reflect(int[][] grid) {
        int[][] reflected = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                reflected[i][2 - j] = grid[i][j];
            }
        }
        return reflected;
    }
}
