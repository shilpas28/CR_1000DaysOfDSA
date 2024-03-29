//Leetcode
//2962. Count Subarrays Where Max Element Appears at Least K Times
//Time complexity: O(n)
//Space complexity: O(1)

package Leetcode;

public class CountSubarraysWhereMaxElementAppearsAtleastKTimes_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 3 };
        int k = 2;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }

        int i = 0, j = 0, cnt = 0;
        long ans = 0;

        while (j < n) {
            if (nums[j] == maxi) {
                cnt++;
            }
            if (cnt >= k) {
                while (cnt >= k) {
                    ans += n - j;
                    if (nums[i] == maxi) {
                        cnt--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
