//Leetcode
//2099. Find Subsequence of Length K With the Largest Sum - Quick Select
//Time complexity: O(n), worst O(n ^ 2)
//Space complexity: O(n)

import java.util.Arrays;

public class FindSubsequenceOfLengthKWithTheLargestSum {

    public static void main(String[] args) {
        int nums[] = { 2, 1, 3, 3, };
        int k = 2;
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] index = new int[n];
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }
        // Use Quick Select to put the indexes of the
        // max k items to the left of index array.
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int idx = quickSelect(nums, index, lo, hi);
            if (idx < k) {
                lo = idx + 1;
            } else {
                hi = idx;
            }
        }
        // Count the occurrencs of the kth largest items
        // within the k largest ones.
        int kthVal = nums[index[k - 1]], freqOfkthVal = 0;
        for (int i : Arrays.copyOf(index, k)) {
            freqOfkthVal += nums[i] == kthVal ? 1 : 0;
        }
        // Greedily copy the subsequence into output array seq.
        int[] seq = new int[k];
        int i = 0;
        for (int num : nums) {
            if (num > kthVal || num == kthVal && freqOfkthVal-- > 0) {
                seq[i++] = num;
            }
        }
        return seq;
    }

    // Divide index[lo...hi] into two parts: larger and less than
    // the pivot; Then return the position of the pivot;
    static int quickSelect(int[] nums, int[] index, int lo, int hi) {
        int pivot = index[lo];
        while (lo < hi) {
            while (lo < hi && nums[index[hi]] <= nums[pivot]) {
                --hi;
            }
            index[lo] = index[hi];
            while (lo < hi && nums[index[lo]] >= nums[pivot]) {
                ++lo;
            }
            index[hi] = index[lo];
        }
        index[lo] = pivot;
        return lo;
    }
}
