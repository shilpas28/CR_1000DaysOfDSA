//Leetcode - Optimal method
//4. Median of Two Sorted Arrays
//Time complexity: O(log(min(n1,n2))), where n1 and n2 are the sizes of two given arrays.
//We are applying binary search on the range [0, min(n1, n2)].
//Space complexity: O(1) as no extra space is used.

package Leetcode;

public class MedianOfTwoSortedArrays_3 {
    public static void main(String[] args) {

        int[] nums1 = { 1, 2 }, nums2 = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        // if n1 is bigger swap the arrays:
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2; // total length
        int left = (n1 + n2 + 1) / 2; // length of left half
        // apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            // calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0; // dummy statement
    }
}
