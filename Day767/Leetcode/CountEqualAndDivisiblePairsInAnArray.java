//Leetcode
//2176. Count Equal and Divisible Pairs in an Array - Brute Force 
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class CountEqualAndDivisiblePairsInAnArray {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 2, 2, 1, 3 };
        int k = 2;
        System.out.println(countPairs(nums, k));
    }

    public static int countPairs(int[] nums, int k) {
        int pairs = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
