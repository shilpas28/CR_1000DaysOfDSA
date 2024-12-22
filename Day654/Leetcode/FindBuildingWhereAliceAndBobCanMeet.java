//Leetcode
//2940. Find Building Where Alice and Bob Can Meet
//Time complexity: O(qlogq)
//Space complexity: O(q) where q = queries.size

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("all")
public class FindBuildingWhereAliceAndBobCanMeet {

    public static void main(String[] args) {
        int[] heights = { 6, 4, 8, 5, 2, 7 };
        int[][] queries = { { 0, 1 }, { 0, 3 }, { 2, 4 }, { 3, 4 }, { 2, 2 } };
        System.out.println(Arrays.toString(leftmostBuildingQueries(heights, queries)));
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, qn = queries.length;
        List<int[]>[] que = new ArrayList[n];
        for (int i = 0; i < n; i++)
            que[i] = new ArrayList<>();
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[qn];
        Arrays.fill(res, -1);
        // Step 1
        for (int qi = 0; qi < qn; qi++) {
            int i = queries[qi][0], j = queries[qi][1];
            if (i < j && heights[i] < heights[j]) {
                res[qi] = j;
            } else if (i > j && heights[i] > heights[j]) {
                res[qi] = i;
            } else if (i == j) {
                res[qi] = i;
            } else { // Step 2
                que[Math.max(i, j)].add(new int[] { Math.max(heights[i], heights[j]), qi });
            }
        }
        // Step 3
        for (int i = 0; i < n; i++) {
            while (!h.isEmpty() && h.peek()[0] < heights[i]) {
                res[h.poll()[1]] = i;
            }
            for (int[] q : que[i]) {
                h.add(q);
            }
        }
        return res;
    }
}
