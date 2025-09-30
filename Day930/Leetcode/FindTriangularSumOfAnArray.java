//Leetcode
//2221. Find Triangular Sum of an Array
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class FindTriangularSumOfAnArray {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(triangularSum(nums));
    }

    public static int triangularSum(int[] nums) {
        for (int n = nums.length; n > 0; --n) {
            for (int i = 1; i < n; ++i) {
                nums[i - 1] += nums[i];
                nums[i - 1] %= 10;
            }
        }
        return nums[0];
    }
}
