//Leetcode
//3432. Count Partitions with Even Sum Difference
//Time complexity: O(N)
//Space complexity: O(1)

public class CountPartitionsWithEvenSumDifference_2 {

    public static void main(String[] args) {
        int[] nums = {10, 10, 3, 7, 6};
        System.out.println(countPartitions(nums));
    }

    public static int countPartitions(int[] nums) {
        int n = nums.length;
        int total = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        int sumLeft = 0;
        for (int i = 0; i < n - 1; i++) {
            sumLeft += nums[i];
            if ((sumLeft - (total - sumLeft)) % 2 == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
