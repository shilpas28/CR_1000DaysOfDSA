//Leetcode
//905. Sort Array By Parity
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            while(l < r && nums[l] % 2 == 0) l++;
            while(l < r && nums[r] % 2 == 1) r--;
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }
}
