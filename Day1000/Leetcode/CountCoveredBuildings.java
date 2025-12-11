//Leetcode
//3531. Count Covered Buildings
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CountCoveredBuildings {

    public static void main(String[] args) {
        int n = 3;
        int[][] buildings = {{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}};
        System.out.println(countCoveredBuildings(n, buildings));
    }

    public static int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> rowToCol = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colToRow = new HashMap<>();
        for (int building[] : buildings) {
            int x = building[0], y = building[1];
            rowToCol.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            colToRow.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }
        int cnt = 0;
        for (int building[] : buildings) {
            int x = building[0], y = building[1];

            TreeSet<Integer> cols = rowToCol.get(x);
            TreeSet<Integer> rows = colToRow.get(y);

            Integer left = cols.lower(y);
            Integer right = cols.higher(y);
            Integer up = rows.lower(x);
            Integer down = rows.higher(x);

            if ((left != null) && (right != null) && (up != null) && (down != null)) {
                cnt++;
            }
        }
        return cnt;
    }
}
