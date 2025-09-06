//Leetcode
//3495. Minimum Operations to Make Array Elements Zero
//Time complexity: O(queries.length)
//Space complexity: O(1)

public class MinimumOperationsToMakeArrayElementsZero_2 {

    public static void main(String[] args) {
        int[][] queries = { { 1, 2 }, { 2, 4 } };
        System.out.println(minOperations(queries));
    }

    public static long minOperations(int[][] queries) {
        long ans = 0;
        for (int i = 0; i < queries.length; i++) {
            long start = queries[i][0], end = queries[i][1];
            long ops = 0;
            for (long d = 1, prev = 1; d < 17; d++) {
                long cur = prev * 4;
                // Find the intersection between the query interval [start, end] and [prev, cur
                // - 1]
                long l = Math.max(start, prev);
                long r = Math.min(end, cur - 1);
                if (r >= l) {
                    ops += (r - l + 1) * d;
                }
                prev = cur;
            }
            // Each operation handles 2 steps, so we take ceil(ops / 2)
            ans += (ops + 1) / 2;
        }
        return ans;
    }
}
