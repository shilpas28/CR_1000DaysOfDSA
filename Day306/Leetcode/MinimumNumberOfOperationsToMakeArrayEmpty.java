//Leetcode
//2870. Minimum Number of Operations to Make Array Empty
//Time complexity: O(NlogN)
//Space complexity: O(1) 

package Leetcode;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMakeArrayEmpty {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 3, 2, 2, 4, 2, 3, 4 };
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        int s = 0;
        while (s < nums.length) {
            int e = s;

            while (e < nums.length && nums[e] == nums[s]) {
                e++;
            }
            int count = e - s;
            if (count == 1)
                return -1;
            res += count / 3;

            if (count % 3 != 0)
                res++;
            s = e;
        }
        return res;
    }
}
