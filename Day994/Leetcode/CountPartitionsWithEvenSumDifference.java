//Leetcode
//3432. Count Partitions with Even Sum Difference
//Time complexity: O(N)
//Space complexity: O(N) 

public class CountPartitionsWithEvenSumDifference {

    public static void main(String[] args) {
        int[] nums = {10, 10, 3, 7, 6};
        System.out.println(countPartitions(nums));
    }

    public static int countPartitions(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int cnt = 0;

        arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            if ((arr[i] - (arr[n - 1] - arr[i])) % 2 == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
