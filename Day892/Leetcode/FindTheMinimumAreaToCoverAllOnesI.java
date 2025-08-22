//Leetcode
//3195. Find the Minimum Area to Cover All Ones I
//Time complexity: O(rows*column)
//Space complexity: O(1)

public class FindTheMinimumAreaToCoverAllOnesI {

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0 }, { 1, 0, 1 } };
        System.out.println(minimumArea(grid));
    }

    public static int minimumArea(int[][] grid) {
        int minRow = grid.length, maxRow = -1;
        int minCol = grid[0].length, maxCol = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}
