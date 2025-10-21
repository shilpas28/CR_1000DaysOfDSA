//GFG
//Top K Frequent in Array - Not accepted as TLE 
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentInArray {

    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int k = 2;
        System.out.println(topKFreq(arr, k));
    }

    public static ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) { // N
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>( // min heap by default
                // and we cannot use max heap since we wan top k largest
                (a, b) -> {// CUSTOM COMPARATOR
                    if (!a.getValue().equals(b.getValue())) {
                        return a.getValue() - b.getValue(); // frequency in asc
                    } else {
                        return a.getKey() - b.getKey(); // if freq same, sort by key in asc
                    }
                });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {// N
            pq.add(entry);
            if (pq.size() > k)// logK
                pq.poll();

        }

        int[] ans = new int[k];
        int idx = k - 1;
        while (!pq.isEmpty()) {
            ans[idx--] = pq.poll().getKey();
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : ans) {
            res.add(num);
        }
        return res;
    }
}
