//Leetcode
//1262. Greatest Sum Divisible by Three - Dynamic Programming
//Time complexity: O(n)
//Space complexity: O(1)

public class GreatestSumDivisibleByThree_3 {

    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(nums));
    }

    public static int maxSumDivThree(int[] nums) {
        int[] f = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] g = new int[3];
            System.arraycopy(f, 0, g, 0, 3);
            for (int i = 0; i < 3; ++i) {
                g[(i + (num % 3)) % 3] = Math.max(
                        g[(i + (num % 3)) % 3],
                        f[i] + num
                );
            }
            f = g;
        }
        return f[0];
    }
}
