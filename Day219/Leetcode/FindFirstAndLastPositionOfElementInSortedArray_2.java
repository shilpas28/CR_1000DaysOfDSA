//Leetcode
//34. Find First and Last Position of Element in Sorted Array - Optimal method 1
//Time complexity: O(2*logN), where N = size of the given array.
//Reason: We are basically using a lower-bound and upper-bound algorithm.
//Space complexity: O(1) as we are using no extra space.

package Leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_2 {

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, n, target);
        if (lb == n || nums[lb] != target)
            return new int[] { -1, -1 };
        int ub = upperBound(nums, n, target);
        return new int[] { lb, ub - 1 };
    }

    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

}
