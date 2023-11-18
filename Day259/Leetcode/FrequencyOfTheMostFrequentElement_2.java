//Leetcode
//1838. Frequency of the Most Frequent Element - Two Pointers / Sliding Window
//Time complexity: O(n log n) - The code sorts the array, which has a time complexity of O(n log n), where n is the length of 
//the input array nums. The main loop iterates through each element in the sorted array once, so it has a time complexity 
//of O(n), where n is the length of the input array. Overall, the dominant factor is the sorting operation, making the 
//time complexity O(n log n).
//Space complexity: O(1) - The space complexity is O(1) because the code uses a constant amount of extra space, regardless of 
//the size of the input array. The additional space is used for variables like maxFrequency, currentSum, and loop 
//variables (left and right), and it does not depend on the input size. Hence, the space complexity is constant.

package Leetcode;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4 };
        int k = 5;
        System.out.println(maxFrequency(nums, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        
        int maxFrequency = 0; // Initialize the maximum frequency
        long currentSum = 0; // Initialize the current sum of the subarray elements

        Arrays.sort(nums); // Sort the array in ascending order
        for (int left = 0, right = 0; right < nums.length; ++right) {
            currentSum += nums[right]; // Include the current element in the subarray sum
            // Check if the current subarray violates the condition (sum + k < nums[right] *
            // length)
            while (currentSum + k < (long) nums[right] * (right - left + 1)) {
                currentSum -= nums[left]; // Adjust the subarray sum by removing the leftmost element
                left++; // Move the left pointer to the right
            }
            // Update the maximum frequency based on the current subarray length
            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }
        return maxFrequency;
    }
}
