//Leetcode
//2221. Find Triangular Sum of an Array
//Time complexity: O(N)
//Space complexity: O(N)

public class FindTriangularSumOfAnArray_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(triangularSum(nums));
    }

    public static int triangularSum(int[] nums) {
        int length = nums.length;
        while (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            length--;
        }
        return nums[0];
    }
}
