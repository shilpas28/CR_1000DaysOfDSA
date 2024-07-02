//Leetcode
//350. Intersection of Two Arrays II
//Time complexity: Sorting both arrays takes (O(n log n + m log m)), where (n) is the length of nums1 and (m) is the length of nums2. 
//The two-pointer traversal takes (O(n + m)). Thus, the overall time complexity is (O(n log n + m log m + n + m) = O(n log n + m log m)).
//Space complexity: The space complexity is (O(1)) if we ignore the space used for sorting, as we are not using any extra space apart 
//from the input arrays.

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    
    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while( i < l1 && j < l2)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}
