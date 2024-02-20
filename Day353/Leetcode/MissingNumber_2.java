//Leetcode
//268. Missing Number
//Time complexity: O(n) (Cycle Sort)
//Space complexity: O(1)

package Leetcode;

public class MissingNumber_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int i = 0; // Cyclic sort code
        while (i < nums.length) {
            int correct = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        // Searching for the missing number after sorting
        for (int index = 0; index < nums.length; index++) {
            if (index != nums[index])
                return index;
        }
        return nums.length;
    }

    // Code for swapping two numbers
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
