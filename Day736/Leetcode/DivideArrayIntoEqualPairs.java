//Leetcode
//2206. Divide Array Into Equal Pairs -  Sorting 
//Time complexity: O(NlogN)
//Space complexity: O(log(2n)) = O(logn)

import java.util.Arrays;

public class DivideArrayIntoEqualPairs {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 2, 2, 2 };
        System.out.println(divideArray(nums));
    }

    public static boolean divideArray(int[] nums) {
        // Sort array to group equal elements together
        Arrays.sort(nums);
        // Check consecutive pairs in sorted array
        for (int pos = 0; pos < nums.length; pos += 2) {
            // If any pair doesn't match, we can't form n equal pairs
            if (nums[pos] != nums[pos + 1]) {
                return false;
            }
        }
        // All pairs found successfully
        return true;
    }
}
