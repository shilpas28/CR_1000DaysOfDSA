//Leetcode
//3346. Maximum Frequency of an Element After Performing Operations I
//Time complexity: O(n+m)
//Space complexity: O(m)

import java.util.Arrays;

public class MaximumFrequencyOfAnElementAfterPerformingOperationsI {

    public static void main(String[] args) {
        int[] nums = { 1, 4, 5 };
        int k = 1, numOperations = 2;
        System.out.println(maxFrequency(nums, k, numOperations));
    }

    public static int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k + 2;
        int[] count = new int[maxVal];

        for (int v : nums)
            count[v]++;

        for (int i = 1; i < maxVal; i++)
            count[i] += count[i - 1];

        int res = 0;
        for (int i = 0; i < maxVal; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(maxVal - 1, i + k);
            int total = count[right] - (left > 0 ? count[left - 1] : 0);
            int freq = count[i] - (i > 0 ? count[i - 1] : 0);
            res = Math.max(res, freq + Math.min(numOperations, total - freq));
        }

        return res;
    }
}
