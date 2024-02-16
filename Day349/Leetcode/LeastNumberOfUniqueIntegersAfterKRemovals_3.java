//Leetcode
//1481. Least Number of Unique Integers after K Removals - HashMap and Array
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeastNumberOfUniqueIntegersAfterKRemovals_3 {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 1, 3, 3, 2 };
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        int remaining = count.size(), occur = 1;
        int[] occurrenceCount = new int[arr.length + 1];
        for (int v : count.values())
            ++occurrenceCount[v];
        while (k > 0) {
            if (k - occur * occurrenceCount[occur] >= 0) {
                k -= occur * occurrenceCount[occur];
                remaining -= occurrenceCount[occur++];
            } else {
                return remaining - k / occur;
            }
        }
        return remaining;
    }
}
