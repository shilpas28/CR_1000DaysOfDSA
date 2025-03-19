//Leetcode
//3191. Minimum Operations to Make Binary Array Elements Equal to One I - Bit Manipulation & Greedy 
//Time complexity: O(N)
//Space complexity: O(1) 

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI_3 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 0 };
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
                count++;
            }
        }

        if (nums[n - 2] == 0 || nums[n - 1] == 0)
            return -1;
        return count;
    }
}
