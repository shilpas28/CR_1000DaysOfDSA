//Leetcode
//3350. Adjacent Increasing Subarrays Detection II
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII {

    public static void main(String[] args) {
        // nums = [2,5,7,8,9,2,3,4,3,1]
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(5);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(3);
        nums.add(1);
        System.out.println(maxIncreasingSubarrays(nums));
    }

    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] end = new int[n];
        int[] start = new int[n];
        Arrays.fill(end, 1);
        Arrays.fill(start, 1);
        // end[i] = length of increasing subarray ending at i
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                end[i] = end[i - 1] + 1;
            }
        }
        // start[i] = length of increasing subarray starting at i
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                start[i] = start[i + 1] + 1;
            }
        }

        int ans = 1;
        // consider split between k and k+1
        for (int k = 0; k + 1 < n; k++) {
            ans = Math.max(ans, Math.min(end[k], start[k + 1]));
        }

        return ans;
    }
}
