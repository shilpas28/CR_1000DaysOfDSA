//Leetcode
//2845. Count of Interesting Subarrays - Brute Force - Not accepted as TLE 
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class CountOfInterestingSubarrays {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(2);
        nums.add(4);
        int modulo = 2, k = 1;
        System.out.println(countInterestingSubarrays(nums, modulo, k));
    }

    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int cnt = 0;
            for (int j = i; j < nums.size(); j++) {
                if (nums.get(j) % modulo == k)
                    cnt++;
                if (cnt % modulo == k)
                    res++;
            }
        }
        return res;
    }
}
