//Leetcode
//2560. House Robber IV - Binary Search 
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class HouseRobberIV_2 {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 9 };
        int k = 2;
        System.out.println(minCapability(nums, k));
    }

    public static int minCapability(int[] nums, int k) {
        int low = 1, high = 0;

        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (func(mid, k, nums)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
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
