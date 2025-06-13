//Leetcode
//2616. Minimize the Maximum Difference of Pairs
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs {

    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 7, 1, 3 };
        int p = 2;
        System.out.println(minimizeMax(nums, p));
    }

    public static int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = nums[n - 1] - nums[0];
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (helper(nums, mid, p) >= p)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int helper(int[] A, int diff, int p) {
        int i = 1;
        int count = 0;
        while (i < A.length) {
            if (A[i] - A[i - 1] <= diff) {
                i++;
                count++;
            }
            i++;
        }
        return count;
    }
}
