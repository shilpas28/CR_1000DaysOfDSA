//Leetcode
//57. Insert Interval - Using Sorting
//Time complexity: O(nlogn)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] res = insert(intervals, newInterval);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // Step 1: Convert array to list
        List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
        // Add new interval to the list
        intervalsList.add(newInterval);
        // Sort intervals based on start value
        Collections.sort(intervalsList, (a, b) -> Integer.compare(a[0], b[0]));
        // Step 2: Merge intervals
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervalsList) {
            if (ansList.size() == 0 || ansList.get(ansList.size() - 1)[1] < interval[0]) {
                ansList.add(interval);
            } else if (ansList.get(ansList.size() - 1)[1] >= interval[0]) {
                ansList.get(ansList.size() - 1)[1] = Math.max(ansList.get(ansList.size() - 1)[1], interval[1]);
            }
        }
        // Step 3: Convert list back to array
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
