//Leetcode
//2364. Count Number of Bad Pairs - Brute Force - Not accepted as TLE 
//Time complexity: O(N^2)
//Space complexity: O(1)

public class CountNumberOfBadPairs {

    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 3 };
        System.out.println(countBadPairs(nums));
    }

    public static long countBadPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((j - i) != (nums[j] - nums[i]))
                    count++;
            }
        }
        return count;
    }
}
