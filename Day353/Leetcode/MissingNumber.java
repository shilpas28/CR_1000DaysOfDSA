//Leetcode
//268. Missing Number
//Time complexity: O(nlogn) 
//Space complexity: O(1) 

package Leetcode;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return nums.length;
    }
}
