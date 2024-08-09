//Leetcode
//840. Magic Squares In Grid
//Time complexity: O(R*C)
//Space complexity: O(1)

public class MagicSquaresInGrid_3 {

    public static void main(String[] args) {
        int[][] grid = { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } };
        System.out.println(numMagicSquaresInside(grid));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if the middle element is 5
        if (grid[row + 1][col + 1] != 5) {
            return false;
        }

        // Get the border elements
        int[] border = getBorderElements(grid, row, col);

        // Check if the border follows the expected sequence
        String[] expectedSequences = { "2943816729438167", "7618349276183492" };
        for (String sequence : expectedSequences) {
            if (isValidBorderSequence(border, sequence)) {
                return true;
            }
        }

        return false;
    }

    static int[] getBorderElements(int[][] grid, int row, int col) {
        int[] border = new int[8];
        int[] borderIndices = { 0, 1, 2, 5, 8, 7, 6, 3 };
        for (int i = 0; i < borderIndices.length; i++) {
            border[i] = grid[row + borderIndices[i] / 3][col + borderIndices[i] % 3];
        }
        return border;
    }

    static boolean isValidBorderSequence(int[] border, String expectedSequence) {
        StringBuilder borderStr = new StringBuilder();
        for (int num : border) {
            borderStr.append(num);
        }
        return expectedSequence.contains(borderStr.toString());
    }
}
