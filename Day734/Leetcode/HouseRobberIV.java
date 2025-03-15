//Leetcode
//2560. House Robber IV - Brute Force - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

public class HouseRobberIV {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 9 };
        int k = 2;
        System.out.println(minCapability(nums, k));
    }

    public static int minCapability(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (func(nums[i], k, nums)) {
                ans = Math.min(ans, nums[i]);
            }
        }
        return ans;
    }

    static boolean func(int max, int k, int[] nums) {
        int cnt = 0, prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max || (prev != -1 && i == prev + 1 || i == prev - 1)) {
                continue;
            } else {
                prev = i;
                cnt++;
            }
        }
        return cnt >= k;
    }
}
