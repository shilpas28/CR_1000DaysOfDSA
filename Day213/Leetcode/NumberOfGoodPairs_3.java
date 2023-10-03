//Leetcode - Optimal method using Counter Array
//1512. Number of Good Pairs
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NumberOfGoodPairs_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {

        int ans = 0;
        int[] count = new int[101];

        for (int n : nums)
            count[n]++;
        for (int n : count)
            ans += (n * (n - 1)) / 2;

        return ans;
    }
}
