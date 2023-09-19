//Leetcode - Brute force method
//287. Find the Duplicate Number- using Sorting 
//Time complexity: O(Nlogn + N) - NlogN for sorting the array and O(N) for traversing through the array 
//and checking if adjacent elements are equal or not. But this will distort the array.
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
