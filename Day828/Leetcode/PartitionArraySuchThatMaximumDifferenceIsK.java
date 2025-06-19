//Leetcode
//2294. Partition Array Such That Maximum Difference Is K - Two Pointers
//Time complexity: O(NlogN)
//Space complexity: O(N) for Sorting

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public static void main(String[] args) {
        int[] nums = { 3, 6, 1, 2, 5 };
        int k = 2;
        System.out.println(partitionArray(nums, k));
    }

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int partitions = 1;
        for (int cur = 1, prev = 0; cur < nums.length; ++cur) {
            if (nums[cur] - nums[prev] > k) {
                ++partitions;
                prev = cur;
            }
        }
        return partitions;
    }
}
