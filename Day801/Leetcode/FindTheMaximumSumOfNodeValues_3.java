//Leetcode
//3068. Find the Maximum Sum of Node Values - Using XOR Operations
//Time complexity: O(N)
//Space complexity: O(1)

public class FindTheMaximumSumOfNodeValues_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int k = 3;
        int[][] edges = { { 0, 1 }, { 0, 2 } };
        System.out.println(maximumValueSum(nums, k, edges));
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {

        long totalSum = 0;
        int count = 0;
        int positiveMin = Integer.MAX_VALUE;
        int negativeMax = Integer.MIN_VALUE;

        for (int nodeValue : nums) {
            int nodeValAfterOperation = nodeValue ^ k;
            totalSum += nodeValue;
            int netChange = nodeValAfterOperation - nodeValue;

            if (netChange > 0) {
                positiveMin = Math.min(positiveMin, netChange);
                totalSum += netChange;
                count += 1;
            } else {
                negativeMax = Math.max(negativeMax, netChange);
            }
        }

        if (count % 2 == 0)
            return totalSum;

        return Math.max(totalSum - positiveMin, totalSum + negativeMax);
    }
}
