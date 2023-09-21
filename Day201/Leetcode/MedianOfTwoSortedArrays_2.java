//Leetcode - Better method
//4. Median of Two Sorted Arrays
//Time complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays. We traverse through both arrays linearly.
//Space complexity: O(1), as we are not using any extra space to solve this problem.

package Leetcode;

public class MedianOfTwoSortedArrays_2 {

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 }, nums2 = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Size of two given arrays
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2; // total size
        // required indices:
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;
        // apply the merge step:
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (cnt == ind1)
                    ind1el = nums1[i];
                if (cnt == ind2)
                    ind2el = nums1[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1)
                    ind1el = nums2[j];
                if (cnt == ind2)
                    ind2el = nums2[j];
                cnt++;
                j++;
            }
        }
        // copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1)
                ind1el = nums1[i];
            if (cnt == ind2)
                ind2el = nums1[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1)
                ind1el = nums2[j];
            if (cnt == ind2)
                ind2el = nums2[j];
            cnt++;
            j++;
        }
        // Find the median:
        if (n % 2 == 1) {
            return (double) ind2el;
        }
        return (double) ((double) (ind1el + ind2el)) / 2.0;
    }
}
