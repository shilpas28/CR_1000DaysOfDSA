//Leetcode
//2540. Minimum Common Value - Using Binary Search
//Time complexity: O(n log m)
//Space complexity: O(1)

package Leetcode;

public class MinimumCommonValue_3 {

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 6 };
        int[] nums2 = { 2, 3, 4, 5 };
        System.out.println(getCommon(nums1, nums2));
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (search(nums2, nums1[i])) {
                return nums1[i];
            }
        }
        return -1;
    }

    static boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
