//Leetcode
//1752. Check if Array Is Sorted and Rotated - Find Smallest Element
//Time complexity: O(N)
//Space complexity: O(1)

public class CheckIfArrayIsSortedAndRotated_3 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return true;
        int inversionCount = 0;
        // For every pair, count the number of inversions.
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                ++inversionCount;
            }
        }
        // Also check between the last and the first element due to rotation
        if (nums[0] < nums[n - 1]) {
            ++inversionCount;
        }
        return inversionCount <= 1;
    }
}
