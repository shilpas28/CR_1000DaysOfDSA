//Leetcode
//525. Contiguous Array - Optimal Method(PreSum + HashMap)
//Time complexity: O(N) as The entire array is traversed only once
//Space complexity: O(N) as size of the HashMap map will be N

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray_2 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int subArrayLength = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                subArrayLength = i + 1;
            } else if (mp.containsKey(sum)) {
                subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return subArrayLength;
    }
}
