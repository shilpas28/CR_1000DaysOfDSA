//Leetcode
//41. First Missing Positive
//Time complexity: O(n), where n is the size of the array. Both iterations through the array take linear time.
//Space complexity: O(1). The algorithm uses only a constant amount of extra space, regardless of the size of the input array.

package Leetcode;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 0 };
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // Place each positive integer i at index i-1 if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // If all positive integers from 1 to n are present, return n + 1
        return n + 1;
    }

    // Function to swap elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
