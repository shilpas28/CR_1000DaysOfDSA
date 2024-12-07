//Leetcode
//1760. Minimum Limit of Balls in a Bag
//Time complexity: O(N * log M)
//Space complexity: O(1)

import java.util.Arrays;

public class MinimumLimitOfBallsInABag {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 8, 2 };
        int maxOperations = 4;
        System.out.println(minimumSize(nums, maxOperations));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (n - 1) / mid;
            }
            if (ops <= maxOperations)
                high = mid;
            else
                low = mid + 1;
        }
        return high;
    }
}
