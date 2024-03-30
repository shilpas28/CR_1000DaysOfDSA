//Leetcode
//992. Subarrays with K Different Integers
//Time complexity: O(N) for two passes.
//Space complexity: O(K) at most K elements in the counter

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    static int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0)
                K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0)
                    K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
