//Leetcode - Priority Queue
//3264. Final Array State After K Multiplication Operations I - Heap-Optimized K Minimum Value Multiplication 
//Time complexity: O(N + klogN)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI_2 {

    public static void main(String[] args) {
        int nums[] = { 2, 1, 3, 5, 6 };
        int k = 5, multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int valueComparison = Integer.compare(a[0], b[0]);
            if (valueComparison == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return valueComparison;
        });

        for (int i = 0; i < nums.length; i++)
            heap.offer(new int[] { nums[i], i });

        while (k-- > 0) {
            int[] smallest = heap.poll();
            int index = smallest[1];

            nums[index] *= multiplier;
            heap.offer(new int[] { nums[index], index });
        }
        return nums;
    }
}
