//Leetcode
//1752. Check if Array Is Sorted and Rotated - Brute Force 
//Time complexity: O(N^2)
//Space complexity: O(N) 

public class CheckIfArrayIsSortedAndRotated {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        // Construct the rotated array
        int[] checkSorted = new int[n];
        // Iterate through all possible rotation offsets
        for (int rotationOffset = 0; rotationOffset < n; ++rotationOffset) {
            int currIndex = 0;
            for (int index = rotationOffset; index < n; ++index) {
                checkSorted[currIndex++] = nums[index];
            }
            for (int index = 0; index < rotationOffset; ++index) {
                checkSorted[currIndex++] = nums[index];
            }
            // Check if the constructed array is sorted
            boolean isSorted = true;
            for (int index = 0; index < n - 1; ++index) {
                if (checkSorted[index] > checkSorted[index + 1]) {
                    isSorted = false;
                    break;
                }
            }
            // If sorted, return true
            if (isSorted) {
                return true;
            }
        }
        // If no rotation makes the array sorted, return false
        return false;
    }
}
