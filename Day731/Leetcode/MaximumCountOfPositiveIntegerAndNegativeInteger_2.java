//Leetcode
//2529. Maximum Count of Positive Integer and Negative Integer - Binary Search
//Time complexity: O(logN)
//Space complexity: O(1) 

public class MaximumCountOfPositiveIntegerAndNegativeInteger_2 {

    public static void main(String[] args) {
        int[] nums = { -2, -1, -1, 1, 2, 3 };
        System.out.println(maximumCount(nums));
    }

    public static int maximumCount(int[] nums) {
        // All integers from the first non-zero to last will be positive
        // integers.
        int positiveCount = nums.length - upperBound(nums);
        // All integers from the index 0 to index before the first zero index
        // will be negative.
        int negativeCount = lowerBound(nums);
        return Math.max(positiveCount, negativeCount);
    }

    // Return the first index where the value is greater than zero.
    static int upperBound(int[] nums) {
        int start = 0, end = nums.length - 1;
        int index = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] <= 0) {
                start = mid + 1;
            } else if (nums[mid] > 0) {
                end = mid - 1;
                index = mid;
            }
        }
        return index;
    }

    // Return the first index where the value is equal to or greater than zero.
    static int lowerBound(int[] nums) {
        int start = 0, end = nums.length - 1;
        int index = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] < 0) {
                start = mid + 1;
            } else if (nums[mid] >= 0) {
                end = mid - 1;
                index = mid;
            }
        }
        return index;
    }
}
