//Leetcode - Recursive approach
//704. Binary Search
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class BinarySearch_1 {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return recursive(nums, low, high, target);
    }

    public static int recursive(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;

        if (nums[mid] == target)
            return mid;

        if (target > nums[mid])
            return recursive(nums, mid + 1, high, target);
        else
            return recursive(nums, low, mid - 1, target);
    }
}
