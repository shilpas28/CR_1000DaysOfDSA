//Leetcode
//2070. Most Beautiful Item for Each Query - TreeMap
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.TreeMap;

public class MostBeautifulItemForEachQuery {

    public static void main(String[] args) {
        int[][] items = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } };
        int[] queries = { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, (a, b) -> (a[0] - b[0]));

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>() {
            {
                put(0, 0);
            }
        };
        int currMax = 0;
        for (int[] item : items) {
            currMax = Math.max(currMax, item[1]); // maintain largerst beauty so far
            map.put(item[0], currMax); // store in treeMap
        }

        for (int i = 0; i < queries.length; ++i)
            result[i] = map.floorEntry(queries[i]).getValue();

        return result;
    }
}
