//Leetcode
//1267. Count Servers that Communicate - Track Using Two Arrays
//Time complexity: O(m*n)
//Space complexity: O(m+n)

public class CountServersThatCommunicate_2 {

    public static void main(String[] args) {
        int[][] grid = { { 1, 0 }, { 1, 1 } };
        System.out.println(countServers(grid));
    }

    public static int countServers(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[] rowCounts = new int[grid[0].length];
        int[] colCounts = new int[grid.length];
        // Count servers in each row and each column
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rowCounts[col]++;
                    colCounts[row]++;
                }
            }
        }

        int communicableServersCount = 0;
        // Count servers that can communicate (in the same row or column)
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    if (rowCounts[col] > 1 || colCounts[row] > 1) {
                        communicableServersCount++;
                    }
                }
            }
        }
        return communicableServersCount;
    }
}
