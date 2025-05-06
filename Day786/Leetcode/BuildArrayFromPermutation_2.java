//Leetcode
//1920. Build Array from Permutation.java
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.Arrays;

public class BuildArrayFromPermutation_2 {

    public static void main(String[] args) {
        int[] nums = { 0, 2, 1, 5, 3, 4 };
        System.out.println(Arrays.toString(buildArray(nums)));
    }

    public static int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++)
            nums[i] = nums[i] + n * (nums[nums[i]] % n);

        for (int i = 0; i < n; i++)
            nums[i] = nums[i] / n;

        return nums;
    }
}
