//Leetcode
//2598. Smallest Missing Non-negative Integer After Operations
//Time complexity: O(N)
//Space complexity: O(N)

public class SmallestMissingNonNegativeIntegerAfterOperations_2 {

    public static void main(String[] args) {
        int[] nums = { 1, -10, 7, 13, 6, 8 };
        int value = 5;
        System.out.println(findSmallestInteger(nums, value));
    }

    public static int findSmallestInteger(int[] nums, int value) {
        int res = 0;
        int[] rem = new int[value];
        for (int x : nums) {
            int r = ((x % value) + value) % value;
            rem[r]++;
        }
        while (rem[res % value]-- > 0)
            res++;
        return res;
    }
}
