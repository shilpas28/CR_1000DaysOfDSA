//Leetcode - using Sets 
//2215. Find the Difference of Two Arrays
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {
    
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1)
            set1.add(num);

        for (int num : nums2)
            set2.add(num);

        List<Integer> el1 = new ArrayList<>();

        for (int num : set1)
            if (!set2.contains(num)) el1.add(num);

        List<Integer> el2 = new ArrayList<>();

        for (int num : set2)
            if (!set1.contains(num)) el2.add(num);

        return Arrays.asList(el1, el2);
    }
}
