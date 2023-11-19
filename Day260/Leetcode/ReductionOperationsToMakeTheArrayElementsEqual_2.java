//Leetcode
//1887. Reduction Operations to Make the Array Elements Equal
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class ReductionOperationsToMakeTheArrayElementsEqual_2 {

    public static void main(String[] args) {
        int[] nums = { 5, 1, 3 };
        System.out.println(reductionOperations(nums));
    }

    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int curr = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
            }
            res = res + curr;
        }
        return res;
    }
}
