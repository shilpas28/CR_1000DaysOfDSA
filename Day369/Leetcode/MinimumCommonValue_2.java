//Leetcode
//2540. Minimum Common Value - Using Set
//Time complexity:
//Space complexity:

package Leetcode;

import java.util.HashSet;

public class MinimumCommonValue_2 {

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 6 };
        int[] nums2 = { 2, 3, 4, 5 };
        System.out.println(getCommon(nums1, nums2));
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                return num;
            }
        }
        return -1;
    }
}
