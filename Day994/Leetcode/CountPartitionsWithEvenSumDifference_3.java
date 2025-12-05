//Leetcode
//3432. Count Partitions with Even Sum Difference
//Time complexity: O(N) 
//Space complexity: O(1)

public class CountPartitionsWithEvenSumDifference_3 {

    public static void main(String[] args) {
        int[] nums = {10, 10, 3, 7, 6};
        System.out.println(countPartitions(nums));
    }

    public static int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        return totalSum % 2 == 0 ? nums.length - 1 : 0;
    }
}
