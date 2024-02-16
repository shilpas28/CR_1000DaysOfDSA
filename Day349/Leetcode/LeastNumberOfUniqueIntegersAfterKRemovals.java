//Leetcode
//1481. Least Number of Unique Integers after K Removals - HashMap and PriorityQueue 
//Time complexity: O(n + klogn)
//Space complexity: O(n)

package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 1, 3, 3, 2 };
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        PriorityQueue<Integer> pq = new PriorityQueue<>(count.values());
        while (k > 0)
            k -= pq.poll();
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}
