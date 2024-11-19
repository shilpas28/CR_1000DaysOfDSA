//Leetcode
//2461. Maximum Sum of Distinct Subarrays With Length K - Sliding Window #2
//Time complexity: O(N)
//Space complexity: O(k)
 
import java.util.HashMap;
import java.util.Map;

public abstract class MaximumSumOfDistinctSubarraysWithLengthK_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        long curSum = 0;

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);

            if (r - l + 1 > k) {
                count.put(nums[l], count.get(nums[l]) - 1);
                if (count.get(nums[l]) == 0) {
                    count.remove(nums[l]);
                }
                curSum -= nums[l];
                l++;
            }

            if (count.size() == r - l + 1 && r - l + 1 == k)
                res = Math.max(res, curSum);
        }
        return res;
    }
}
