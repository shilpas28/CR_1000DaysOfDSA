//Leetcode
//995. Minimum Number of K Consecutive Bit Flips
//Time complexity: O(n), where n is the length of the input array nums. Each element is processed a constant number of times.
//Space complexity: O(n), for the additional isFlipped array used to keep track of the flips.

package Leetcode;

public class MinimumNumberOfKConsecutiveBitFlips_2 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };
        int k = 1;
        System.out.println(minKBitFlips(nums, k));
    }

    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < nums.length; ++i) {
            if (i >= k)
                flipped ^= isFlipped[i - k];
            if (flipped == nums[i]) {
                if (i + k > nums.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}
