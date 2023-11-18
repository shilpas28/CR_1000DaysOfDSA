//Leetcode
//1838. Frequency of the Most Frequent Element - Sliding Window & Greedy
//Time complexity: O(N + K) - Counting Sort (sorting step): O(N + K), where N is the length of the input array nums, and K is 
//the range of values (maximum element in nums). Counting sort has a linear time complexity because it iterates through the 
//input array once to count the occurrences of each element and then reconstructs the sorted array. Main 
//Loop (sliding window): O(N), where N is the length of the input array nums. The main loop iterates through each element of 
//the sorted array once. The overall time complexity is dominated by the counting sort step, making the total time 
//complexity O(N + K).
//Space complexity: O(K) - Counting Sort (sorting step): O(K), where K is the range of values (maximum element in nums). The 
//space required for counting sort is proportional to the range of values in the input array. Other Variables: O(1). The space 
//required for variables such as start, subarraySum, maxFrequency, etc., is constant and does not depend on the input size. 
//The overall space complexity is O(K), where K is the range of values in the input array.

package Leetcode;

public class FrequencyOfTheMostFrequentElement_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4 };
        int k = 5;
        System.out.println(maxFrequency(nums, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        countingSort(nums); // Sort the array using counting sort
        int start = 0; // Start index of the current subarray
        int subarraySum = 0; // Sum of elements in the current subarray
        int maxFrequency = 1; // Initialize the maximum frequency to 1
        // Iterate through the sorted array
        for (int i = 0; i < nums.length; i++) {
            int subarrayLength = i - start + 1; // Length of the current subarray
            int subarrayProduct = nums[i] * subarrayLength; // Product of element and subarray length
            subarraySum += nums[i]; // Add the current element to the subarray sum
            // Adjust the subarray to satisfy the condition (product - sum <= k)
            while (subarrayProduct - subarraySum > k) {
                subarraySum -= nums[start]; // Remove the leftmost element from the subarray
                start++; // Move the start index to the right
                subarrayLength--; // Decrease the length of the subarray
                subarrayProduct = nums[i] * subarrayLength; // Recalculate the product
            }
            // Update the maximum frequency based on the current subarray length
            maxFrequency = Math.max(maxFrequency, subarrayLength);
        }
        return maxFrequency; // Return the final result
    }

    // Counting Sort to sort the array in non-decreasing order
    static void countingSort(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        // Find the maximum element in the array
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }
        // Create an array to store the count of each element
        int[] countMap = new int[maxElement + 1];
        // Count the occurrences of each element in the array
        for (int num : nums) {
            countMap[num]++;
        }
        int index = 0;
        // Reconstruct the sorted array
        for (int i = 0; i <= maxElement; i++) {
            while (countMap[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }
}
