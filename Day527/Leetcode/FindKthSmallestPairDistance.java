//Leetcode
//719. Find K-th Smallest Pair Distance
//Time complexity: O(nlogn+nlogW)
//Space complexity: O(1)

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public static void main(String[] args) {
        int[] nums = { 1, 6, 1 };
        int k = 3;
        System.out.println(smallestDistancePair(nums, k));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int minDistance = 0;
        int maxDistance = nums[nums.length - 1] - nums[0];

        while (minDistance < maxDistance) {
            int midDistance = minDistance + (maxDistance - minDistance) / 2;
            int pairsCount = countPairsWithinDistance(nums, midDistance);
            if (pairsCount < k) {
                minDistance = midDistance + 1;
            } else {
                maxDistance = midDistance;
            }
        }
        return minDistance;
    }

    static int countPairsWithinDistance(int[] numbers, int targetDistance) {
        int count = 0;
        int left = 0;
        for (int right = 1; right < numbers.length; right++) {
            while (numbers[right] - numbers[left] > targetDistance) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
