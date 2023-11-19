//Leetcode
//1887. Reduction Operations to Make the Array Elements Equal
//Time complexity: O(nlogn) - To create HashTable is O(n), to create PriorityQueue from HashTable is O(nlogn) and 
//process the PriorityQueue O(nlogn)
//Space complexity: O(n) - To create HashTable and PriorityQueue

package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReductionOperationsToMakeTheArrayElementsEqual {

    static class Pair {
        int value;
        int count;

        Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 3 };
        System.out.println(reductionOperations(nums));
    }

    public static int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = createMap(nums);
        PriorityQueue<Pair> pq = createPriorityQueue(map);

        int ans = 0;
        while (pq.size() != 1) {
            Pair p = pq.poll();
            ans += p.count;
            pq.peek().count += p.count;
        }
        return ans;
    }

    static PriorityQueue<Pair> createPriorityQueue(Map<Integer, Integer> map) {
        PriorityQueue<Pair> pQueue = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
        for (int val : map.keySet()) {
            pQueue.add(new Pair(val, map.get(val)));
        }
        return pQueue;
    }

    static Map<Integer, Integer> createMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        return map;
    }
}
