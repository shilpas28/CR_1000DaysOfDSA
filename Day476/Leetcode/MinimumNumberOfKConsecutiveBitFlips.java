//Leetcode
//995. Minimum Number of K Consecutive Bit Flips - Greedy algorithm - Brute force
//Time complexity: O(n*k) - Not accepted as TLE
//Space complexity: O(1)

package Leetcode;

public class MinimumNumberOfKConsecutiveBitFlips {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };
        int k = 1;
        System.out.println(minKBitFlips(nums, k));
    }

    public static int minKBitFlips(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i + k > nums.length)
                    return -1;
                flip(nums, k, i);
                cnt++;
            }
        }
        return cnt;
    }

    static void flip(int[] A, int K, int i) {
        for (int j = i; j < i + K; j++) {
            A[j] = 1 - A[j];
        }
    }
}
