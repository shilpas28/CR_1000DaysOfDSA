//leetcode
//81. Search in Rotated Sorted Array II
//Time complexity: O(logN) for the best and average case. O(N/2) for the worst case. Here, N = size of the given array.
//Space complexity: O(1)

package Leetcode;

public class SearchInRotatedSortedArrayII_2 {

    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int n = nums.length; // size of the array.
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // if mid points the target
            if (nums[mid] == target)
                return true;
            // Edge case:
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            // if left part is sorted:
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // element exists:
                    high = mid - 1;
                } else {
                    // element does not exist:
                    low = mid + 1;
                }
            } else { // if right part is sorted:
                if (nums[mid] <= target && target <= nums[high]) {
                    // element exists:
                    low = mid + 1;
                } else {
                    // element does not exist:
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
