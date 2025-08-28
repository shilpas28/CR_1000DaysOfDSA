//Leetcode
//3446. Sort Matrix by Diagonals
//Time complexity: O(nmlog(min(n,m)))
//Space complexity: O(n*m)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class SortMatrixByDiagonals {

    public static void main(String[] args) {
        int[][] grid = { { 1, 7, 3 }, { 9, 8, 2 }, { 4, 5, 6 } };
        int[][] res = sortMatrix(grid);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int key = i - j;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(grid[i][j]);
            }
        }

        for (int key : map.keySet()) {
            if (key < 0) {
                ArrayList list = map.get(key);
                Collections.sort(list);
                map.put(key, list);
            } else {
                ArrayList list = map.get(key);
                Collections.sort(list, Collections.reverseOrder());
                map.put(key, list);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int key = i - j;
                grid[i][j] = map.get(key).get(0);
                map.get(key).remove(0);
            }
        }
        return grid;
    }
}
