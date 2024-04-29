//Leetcode
//2997. Minimum Number of Operations to Make Array XOR Equal to K
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumNoOfOperationsToMakeArrayXOREqualToK {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 4 };
        int k = 1;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int x : nums) {
            ans = ans ^ x;
        }
        ans = ans ^ k;
        int res = 0;
        while (ans > 0) {
            if ((ans & 1) != 0)
                res++;
            ans = ans >> 1;
        }
        return res;
    }
}
