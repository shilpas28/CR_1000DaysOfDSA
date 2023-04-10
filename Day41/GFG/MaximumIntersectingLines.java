//GFG
//Maximum Intersecting Lines
//Time complexity: O(N*log(N))
//Space complexity: O(N)

import java.util.Map;
import java.util.TreeMap;


public class MaximumIntersectingLines {
    public static void main(String[] args) {
        int N = 4;
        int lines[][] = { { 1, 3 }, { 2, 3 }, { 1, 2 }, { 4, 4 } };
        System.out.println(maxIntersections(lines, N));
    }

    public static int maxIntersections(int[][] lines, int N) {
        // Code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int line[] : lines) {
            map.put(line[0], map.getOrDefault(line[0], 0) + 1);
            map.put(line[1] + 1, map.getOrDefault(line[1] + 1, 0) - 1);
        }

        int ans = 0, sum = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            sum += m.getValue();
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
