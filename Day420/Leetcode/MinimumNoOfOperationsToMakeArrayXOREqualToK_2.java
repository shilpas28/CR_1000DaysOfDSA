//Leetcode
//2997. Minimum Number of Operations to Make Array XOR Equal to K
//Time complexity: O(N)
//Space complexity: O(1)
 
package Leetcode;

public class MinimumNoOfOperationsToMakeArrayXOREqualToK_2 {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 4 };
        int k = 1;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        int finalXor = 0;
        // XOR of all integers in the array.
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }
        int count = 0;
        // Keep iterating until both k and finalXor becomes zero.
        while (k > 0 || finalXor > 0) {
            // k % 2 returns the rightmost bit in k,
            // finalXor % 2 returns the rightmost bit in finalXor.
            // Increment counter, if the bits don't match.
            if ((k % 2) != (finalXor % 2)) {
                count++;
            }
            // Remove the last bit from both integers.
            k /= 2;
            finalXor /= 2;
        }
        return count;
    }
}
