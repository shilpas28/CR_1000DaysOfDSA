//Leetcode
//2845. Count of Interesting Subarrays - Using Prefix Modulo
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfInterestingSubarrays_2 {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(2);
        nums.add(4);
        int modulo = 2, k = 1;
        System.out.println(countInterestingSubarrays(nums, modulo, k));
    }

    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long count = 0, equals = 0;
        Map<Integer, Long> mpp = new HashMap<>();
        mpp.put(0, 1L);
        for (int i : nums) {
            if (i % modulo == k)
                equals++;
            int rem = (int) (equals % modulo);
            int needed = (rem - k + modulo) % modulo;
            count += mpp.getOrDefault(needed, 0L);
            mpp.put(rem, mpp.getOrDefault(rem, 0L) + 1);
        }
        return count;
    }
}
