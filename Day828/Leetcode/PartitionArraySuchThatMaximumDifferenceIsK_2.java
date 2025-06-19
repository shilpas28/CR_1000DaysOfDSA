//Leetcode
//2294. Partition Array Such That Maximum Difference Is K - Binary Search
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 6, 1, 2, 5 };
        int k = 2;
        System.out.println(partitionArray(nums, k));
    }

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int key = nums[0] + k, partitions = 1;
        while (binarySearch(nums, key) < nums.length) {
            ++partitions;
            key = nums[binarySearch(nums, key)] + k;
        }
        return partitions;
    }

    static int binarySearch(int[] nums, int key) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
