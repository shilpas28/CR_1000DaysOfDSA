//Leetcode
//1877. Minimize Maximum Pair Sum in Array
//Time complexity: O(N) - Iterating through the array to populate the frequency array and find min and max numbers: (O(n)), 
//where (n) is the length of the array. The while loop iterates until the low pointer is less than or equal to the high pointer. 
//In each iteration, we either increment the low pointer or decrement the high pointer. Since both pointers move towards each 
//other, the total number of iterations is (O(n)). Each iteration involves constant-time operations (comparison, addition, 
//subtraction), so the overall time complexity is (O(n)).
//Space complexity: O(1) - The frequency array has a fixed size of 100001. Therefore, the space complexity is (O(1)) because the 
//size of the array is constant regardless of the input size. Other variables (maxSum, minNum, maxNum, low, high) are all scalar 
//variables, and their space complexity is constant.

package Leetcode;

public class MinimizeMaximumPairSumInArray_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 5, 2, 3 };
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Variable to store the minimized maximum pair sum
        int minNum = Integer.MAX_VALUE; // Variable to store the minimum number in the array
        int maxNum = Integer.MIN_VALUE; // Variable to store the maximum number in the array

        int frequency[] = new int[100001]; // Array to store the frequency of each number in the array
        // Iterate through the array to populate frequency array and find min and max
        // numbers
        for (int num : nums) {
            frequency[num]++;
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        // Initialize pointers for two numbers to form pairs
        int low = minNum;
        int high = maxNum;
        // Iterate while low pointer is less than or equal to high pointer
        while (low <= high) {
            // If frequency of the number at low pointer is zero, move low pointer to the
            // right
            if (frequency[low] == 0) {
                low++;
            }
            // If frequency of the number at high pointer is zero, move high pointer to the
            // left
            else if (frequency[high] == 0) {
                high--;
            }
            // Both low and high pointers point to valid numbers
            else {
                // Calculate the sum of the pair at the current pointers
                int currentPairSum = low + high;
                // Update maxSum if the current pair sum is greater
                maxSum = Math.max(maxSum, currentPairSum);
                // Decrease the frequency of the numbers at low and high pointers
                frequency[low]--;
                frequency[high]--;
            }
        }
        return maxSum; // Return the minimized maximum pair sum
    }
}
