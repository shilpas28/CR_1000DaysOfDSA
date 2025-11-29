//Leetcode
//3512. Minimum Operations to Make Array Sum Divisible by K
//Time complexity: O(N)
//Space complexity: O(1)

public class MinimumOperationsToMakeArraySumDivisibleByK {

    public static void main(String[] args) {
        int[] nums = {3, 9, 7};
        int k = 5;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum % k;
    } 
}  
