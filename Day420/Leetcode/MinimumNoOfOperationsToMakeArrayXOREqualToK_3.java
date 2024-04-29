//Leetcode
//2997. Minimum Number of Operations to Make Array XOR Equal to K
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class MinimumNoOfOperationsToMakeArrayXOREqualToK_3 {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 4 };
        int k = 1;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        for (int a : nums)
            k ^= a;
        return Integer.bitCount(k);
    }
}
