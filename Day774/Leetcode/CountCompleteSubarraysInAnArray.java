//Leetcode
//2799. Count Complete Subarrays in an Array - Brute Force 
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountCompleteSubarraysInAnArray {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 2, 2 };
        System.out.println(countCompleteSubarrays(nums));
    }

    public static int countCompleteSubarrays(int[] nums) {
        int k = (int) Arrays.stream(nums).distinct().count(), res = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                st.add(nums[j]);
                if (st.size() == k)
                    res++;
            }
        }
        return res;
    }
}
