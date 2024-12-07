//Leetcode
//1760. Minimum Limit of Balls in a Bag
//Time complexity: O(N * log M) 
//Space complexity: O(1) 

import java.util.Arrays;

public class MinimumLimitOfBallsInABag_2 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 8, 2 };
        int maxOperations = 4;
        System.out.println(minimumSize(nums, maxOperations));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int res = right;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, mid, maxOperations)) {
                right = mid;
                res = right;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    static boolean canDivide(int[] nums, int maxBalls, int maxOperations) {
        int ops = 0;
        for (int n : nums) {
            ops += (n + maxBalls - 1) / maxBalls - 1;
            if (ops > maxOperations)
                return false;
        }
        return true;
    }
}
