//Leetcode
//2962. Count Subarrays Where Max Element Appears at Least K Times
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSubarraysWhereMaxElementAppearsAtleastKTimes {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 3 };
        int k = 2;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, int k) {
        int maxnum = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int n = nums.length;

        List<Integer> maxind = new ArrayList<>();
        maxind.add(-1); // Initialize with -1 to handle edge case
        for (int i = 0; i < n; i++) {
            if (nums[i] == maxnum) {
                maxind.add(i);
            }
        }

        int indsize = maxind.size();
        for (int i = 1; i <= indsize - k; i++) {
            long l = maxind.get(i) - maxind.get(i - 1) - 1;
            long r = n - 1 - maxind.get(i + k - 1);
            ans += (l + 1) * (r + 1);
        }
        return ans;
    }
}
