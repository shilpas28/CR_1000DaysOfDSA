//Leetcode
//3349. Adjacent Increasing Subarrays Detection I
//Time complexity: O(n)
//Space complexity: O(1) 

import java.util.ArrayList;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI_2 {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(5);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(3);
        nums.add(1);
        int k = 3;
        System.out.println(hasIncreasingSubarrays(nums, k));
    }

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int inc = 1, prevInc = 0, maxLen = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                inc++;
            else {
                prevInc = inc;
                inc = 1;
            }
            maxLen = Math.max(maxLen, Math.max(inc >> 1, Math.min(prevInc, inc)));
            if (maxLen >= k)
                return true;
        }
        return false;
    }
}
