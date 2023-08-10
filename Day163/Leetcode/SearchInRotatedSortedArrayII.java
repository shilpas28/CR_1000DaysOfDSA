//Leetcode
//81. Search in Rotated Sorted Array II
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int n = nums.length; // size of the array.
        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                return true;
        }
        return false;
    }
}
