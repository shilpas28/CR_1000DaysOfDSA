//Leetcode
//2352. Equal Row and Column Pairs
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    
    public static void main(String[] args) {
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> rowCounts = new HashMap<>();
        int count = 0;
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rowCounts.put(key, rowCounts.getOrDefault(key, 0) + 1);
        }
        for (int col = 0; col < grid[0].length; col++) {
            int[] column = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                column[row] = grid[row][col];
            }
            String key = Arrays.toString(column);
            count += rowCounts.getOrDefault(key, 0);
        }
        return count;
    }
}
