//Leetcode
//962. Maximum Width Ramp - Sort and solve
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class MaximumWidthRamp_2 {

    public static void main(String[] args) {
        int[] nums = { 6, 0, 8, 2, 1, 5 };
        System.out.println(maxWidthRamp(nums));
    }

    public static int maxWidthRamp(int[] nums) {
        // sort index according to values and then do a dp
        int N = nums.length;
        Integer[] indices = new Integer[N]; // need to use Integer for Arrays.sort with lambda to work
        Arrays.setAll(indices, i -> i);
        Arrays.sort(indices, (i, j) -> nums[i] != nums[j] ? nums[i] - nums[j] : i - j);
        // use dp to find min idx so far
        int minIdx = indices[0];
        int res = 0;
        for (int idx : indices) {
            res = Math.max(res, idx - minIdx);
            minIdx = Math.min(minIdx, idx);
        }
        return res;
    }
}
