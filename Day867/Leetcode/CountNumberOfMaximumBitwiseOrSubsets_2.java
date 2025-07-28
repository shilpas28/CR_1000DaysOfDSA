//Leetcode
//2044. Count Number of Maximum Bitwise-OR Subsets
//Time complexity: O(mn), where m = max(A)
//Space complexity: O(m)

public class CountNumberOfMaximumBitwiseOrSubsets_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 1 };
        System.out.println(countMaxOrSubsets(nums));
    }

    public static int countMaxOrSubsets(int[] nums) {
        int max = 0, dp[] = new int[1 << 17];
        dp[0] = 1;
        for (int a : nums) {
            for (int i = max; i >= 0; --i)
                dp[i | a] += dp[i];
            max |= a;
        }
        return dp[max];
    }
}
