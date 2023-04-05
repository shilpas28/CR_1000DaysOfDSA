//Leetcode - most Optimal solution
//2439. Minimize Maximum of Array
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimizeMaximumOfArray_2 {

    public static void main(String[] args) {
        int nums[] = { 3, 7, 1, 6 };
        System.out.println(minimizeArrayValue(nums));
    }

    public static int minimizeArrayValue(int[] nums) {
        long sum = 0, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            res = Math.max(res, (sum + i) / (i + 1));
        }
        return (int) res;
    }

}
