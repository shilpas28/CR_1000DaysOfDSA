//Leetcode
//896. Monotonic Array
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MonotonicArray {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3 };
        System.out.println(isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                decreasing = false;
            if (nums[i] > nums[i + 1])
                increasing = false;
        }
        return increasing || decreasing;
    }
}
