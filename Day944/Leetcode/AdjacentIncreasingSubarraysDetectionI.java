//Leetcode
//3349. Adjacent Increasing Subarrays Detection I
//Time complexity: O(n×k)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(5);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(3);
        nums.add(1);
        int k = 3;
        System.out.println(hasIncreasingSubarrays(nums, k));
    }

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k)
            return false;

        for (int i = 0; i <= n - 2 * k; i++) {
            if (isStrictlyIncreasing(nums, i, k) && isStrictlyIncreasing(nums, i + k, k)) {
                return true;
            }
        }

        return false;
    }

    static boolean isStrictlyIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1))
                return false;
        }
        return true;
    }
}
