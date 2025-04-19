//Leetcode
//2563. Count the Number of Fair Pairs - Binary Search
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class CountTheNumberOfFairPairs {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 7, 4, 4, 5 };
        int lower = 3, upper = 6;
        System.out.println(countFairPairs(nums, lower, upper));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int lT = lower - num; // lower Target
            int uT = upper - num; // upper Target
            // k - j thing explained above
            count += (lowerUpperBound(nums, uT, i + 1, nums.length - 1, true) -
                    lowerUpperBound(nums, lT, i + 1, nums.length - 1, false));
        }
        return count;
    }

    public static long lowerUpperBound(int[] arr, int target, int l, int r, boolean isUpper) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (!isUpper) { // BS lower bound
                if (arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { // BS upper bound
                if (arr[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        long ans = isUpper ? r : l - 1;
        return ans;
    }
}
