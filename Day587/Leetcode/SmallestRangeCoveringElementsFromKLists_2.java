//Leetcode
//632. Smallest Range Covering Elements from K Lists
//Time complexity: O(Nlogk)
//Space complexity: O(k)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists_2 {

    public static void main(String[] args) {
        // nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        // Min-Heap: stores (value, list index, element index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int curMax = Integer.MIN_VALUE;
        // Initialize the heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new int[] { nums.get(i).get(0), i, 0 });
            curMax = Math.max(curMax, nums.get(i).get(0));
        }
        // Track the smallest range
        int[] smallRange = new int[] { 0, Integer.MAX_VALUE };

        while (true) {
            // Get the minimum element from the heap
            int[] curr = minHeap.poll();
            int curMin = curr[0], listIdx = curr[1], elemIdx = curr[2];
            // Update the smallest range if a better one is found
            if ((curMax - curMin < smallRange[1] - smallRange[0]) ||
                    (curMax - curMin == smallRange[1] - smallRange[0] && curMin < smallRange[0])) {
                smallRange[0] = curMin;
                smallRange[1] = curMax;
            }
            // Move to the next element in the same list
            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                minHeap.offer(new int[] { nextVal, listIdx, elemIdx + 1 });
                curMax = Math.max(curMax, nextVal);
            } else {
                // If any list is exhausted, stop
                break;
            }
        }
        return smallRange;
    }
}
