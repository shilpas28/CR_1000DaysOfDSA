//Leetcode
//3375. Minimum Operations to Make Array Values Equal to K - Using Sorting
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class MinimumOperationsToMakeArrayValuesEqualToK {

    public static void main(String[] args) {
        int nums[] = { 5, 2, 5, 4, 5 };
        int k = 2;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int mini = nums[0];
        if (mini < k)
            return -1;

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                cnt++;
                while (i + 1 < nums.length && nums[i] == nums[i + 1])
                    i++;
            }
        }
        return cnt;
    }
}
