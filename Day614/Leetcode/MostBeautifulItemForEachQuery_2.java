//Leetcode
//2070. Most Beautiful Item for Each Query - Binary Search
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class MostBeautifulItemForEachQuery_2 {

    public static void main(String[] args) {
        int[][] items = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } };
        int[] queries = { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, (a, b) -> (a[0] - b[0]));

        for (int i = 1; i < items.length; ++i)
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);

        for (int j = 0; j < queries.length; ++j)
            result[j] = binarySearch(items, queries[j]);

        return result;
    }

    static int binarySearch(int[][] items, int target) {
        int lo = 0, hi = items.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1; // find rightmost item
            if (items[mid][0] > target)
                hi = mid - 1;
            else
                lo = mid;
        }
        return items[lo][0] <= target ? items[lo][1] : 0;
    }
}
