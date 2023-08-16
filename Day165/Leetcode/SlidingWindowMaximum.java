//Leetcode - doesnt accept this solution as TLE
//239. Sliding Window Maximum
//Time complexity: O(N^2)
//Space complexity: O(K)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
        // System.out.println(maxSlidingWindow(nums, k));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0;
        ArrayList<Integer> maxx = new ArrayList<>();
        while (right < k - 1) {
            right++;
        }
        while (right < nums.length) {
            GetMax(nums, left, right, maxx);
            left++;
            right++;
        }
        return maxx.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void GetMax(int[] nums, int left, int right, ArrayList<Integer> maxx) {
        int i, maxi = Integer.MIN_VALUE;
        for (i = left; i <= right; i++)
            maxi = Math.max(maxi, nums[i]);
        maxx.add(maxi);
    }
}
