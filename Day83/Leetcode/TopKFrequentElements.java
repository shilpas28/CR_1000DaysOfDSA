//Leetcode
//347. Top K Frequent Elements
//Time complexity: O(Nlogk)
//Space complexity: O(k)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        int[] result = new int[k];
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : nums) {
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }

        Queue<Integer> PQ = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        for (int x : counts.keySet())
            PQ.add(x);
        for (int i = 0; i < k; ++i) {
            result[i] = PQ.poll();
        }
        return result;
    }
}
