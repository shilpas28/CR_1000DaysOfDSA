//Leetcode
//2342. Max Sum of a Pair With Equal Sum of Digits - Priority Queue
//Time complexity: O(nlogm)
//Space complexity: O(logm)

import java.util.PriorityQueue;

@SuppressWarnings("all")
public class MaxSumOfAPairWithEqualSumOfDigits_2 {

    public static void main(String[] args) {
        int[] nums = { 18, 43, 36, 13, 7 };
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        // Array to store a min heap for each possible digit sum (0 to 81)
        PriorityQueue<Integer>[] digitSumGroups = new PriorityQueue[82];
        for (int i = 0; i < 82; i++) {
            digitSumGroups[i] = new PriorityQueue<Integer>();
        }

        int maxPairSum = -1;
        // Group numbers by their digit sums, maintaining heap size of 2
        for (int number : nums) {
            int digitSum = calculateDigitSum(number);
            digitSumGroups[digitSum].add(number);
            // Keep only the top 2 largest numbers in the heap
            if (digitSumGroups[digitSum].size() > 2) {
                digitSumGroups[digitSum].poll(); // Remove the smallest element
            }
        }
        // Traverse the vector to find the maximum pair sum for each group
        for (PriorityQueue<Integer> minHeap : digitSumGroups) {
            if (minHeap.size() == 2) {
                int first = minHeap.poll();
                int second = minHeap.poll();
                maxPairSum = Math.max(maxPairSum, first + second);
            }
        }
        return maxPairSum;
    }

    // Helper function to compute the sum of digits of a number
    static int calculateDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }
}
