//Leetcode
//3362. Zero Array Transformation III
//Time complexity: O(n + qlogq)
//Space complexity: O(q)

import java.util.Arrays;
import java.util.PriorityQueue;

public class ZeroArrayTransformationIII {

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2 };
        int[][] queries = { { 0, 2 }, { 0, 2 }, { 1, 1 } };
        System.out.println(maxRemoval(nums, queries));
    }

    public static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length, nq = queries.length;
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> h = new PriorityQueue<>(); // min heap
        int[] end = new int[n + 1];
        int cur = 0, j = 0;
        for (int i = 0; i < n; ++i) {
            cur -= end[i];
            while (j < nq && queries[j][0] <= i) {
                h.offer(-queries[j][1]); // Add negative for min-heap
                j++;
            }
            while (cur < nums[i]) {
                if (h.isEmpty() || -h.peek() < i) {
                    return -1;
                }
                end[-h.poll() + 1]++;
                cur++;
            }
        }
        return h.size();
    }
}
