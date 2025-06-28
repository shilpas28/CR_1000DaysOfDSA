//Leetcode
//2099. Find Subsequence of Length K With the Largest Sum - Sort
//Time complexity: O(n * logn)
//Space complexity: O(n)

import java.util.Arrays;
import java.util.Comparator;

public class FindSubsequenceOfLengthKWithTheLargestSum_2 {

    public static void main(String[] args) {
        int nums[] = { 2, 1, 3, 3, };
        int k = 2;
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] indexAndVal = new int[n][2];
        for (int i = 0; i < n; ++i) {
            indexAndVal[i] = new int[] { i, nums[i] };
        }
        // Reversely sort by value.
        Arrays.sort(indexAndVal, Comparator.comparingInt(a -> -a[1]));
        int[][] maxK = Arrays.copyOf(indexAndVal, k);
        // Sort by index.
        Arrays.sort(maxK, Comparator.comparingInt(a -> a[0]));
        int[] seq = new int[k];
        for (int i = 0; i < k; ++i) {
            seq[i] = maxK[i][1];
        }
        return seq;
    }

}
