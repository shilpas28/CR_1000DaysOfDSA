//Leetcode
//1838. Frequency of the Most Frequent Element - Binary Search with Prefix Sum
//Time complexity: O(n log n) - The initial sorting of the array takes O(n log n) time, where n is the length of the array. 
//Calculating differences and prefix sums involves iterating through the array once, which takes O(n) time. The binary search 
//iterates log(n) times. The isPossible function iterates through the array once, making it O(n). The overall time complexity 
//is dominated by the sorting step, making it O(n log n).
//Space complexity: O(n) - Additional space is used to store the arrays differences and prefixSums, each of size n. Therefore, 
//the space complexity for these arrays is O(n). Other variables like low, high, mid, times, and minTimes use constant space. 
//The overall space complexity is O(n) due to the additional arrays created for differences and prefix sums.

package Leetcode;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4 };
        int k = 5;
        System.out.println(maxFrequency(nums, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        int length = nums.length;
        // Calculate the differences between adjacent elements
        long[] differences = new long[length];
        for (int i = 1; i < length; i++)
            differences[i] = (long) nums[i] - (long) nums[i - 1];
        // Calculate the prefix sums of the differences
        long[] prefixSums = new long[length];
        for (int i = 1; i < length; i++)
            prefixSums[i] = prefixSums[i - 1] + differences[i];
        int low = 1, high = length;
        // Binary search for the maximum frequency
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            // Check if it's possible to achieve the given frequency with the allowed
            // difference
            if (isPossible(nums, differences, prefixSums, mid, k))
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    // Function to check if it's possible to achieve the given frequency with the
    // allowed difference
    static boolean isPossible(int[] nums, long[] differences, long[] prefixSums, int freq, int k) {
        int length = differences.length;
        long times = 0;
        // Calculate the initial times based on the frequency and the last element in
        // the subarray
        for (int i = freq - 2; i >= 0; i--)
            times += (long) nums[freq - 1] - (long) nums[i];

        long minTimes = times;
        // Iterate from freq-th element to the end of the array
        for (int i = freq; i < length; i++) {
            // Update times by considering the difference in prefix sums and new differences
            times = times - (prefixSums[i - 1] - prefixSums[i - freq]) + differences[i] * (freq - 1);
            minTimes = Math.min(minTimes, times);
        }
        // Check if the minimum times is within the allowed difference (k)
        return minTimes <= (long) k;
    }
}
