import java.util.TreeMap;

//GFG
//Maximum Intersecting Lines - Using Map
//Time complexity: O(N*log(N))
//Space complexity: O(N)

public class MaximumIntersectingLines_2 {
    public static void main(String[] args) {
        int N = 4;
        int lines[][] = { { 1, 3 }, { 2, 3 }, { 1, 2 }, { 4, 4 } };
        System.out.println(maxIntersections(lines, N));
    }

    public static int maxIntersections(int[][] lines, int N) {
        // Code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] line : lines) {
            int start = line[0], end = line[1] + 1;
            map.putIfAbsent(start, 0);
            map.putIfAbsent(end, 0);

            map.put(start, map.get(start) + 1);
            map.put(end, map.get(end) - 1);
        }

        int res = 0, cnt = 0;
        for (Integer value : map.values()) {
            cnt += value;
            res = Math.max(res, cnt);
        }
        return res;
    }
}
