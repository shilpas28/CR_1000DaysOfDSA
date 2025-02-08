//Leetcode
//2349. Design a Number Container System - Using Min Heap with Lazy Update 
//Time complexity: O(logN)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignANumberContainerSystem_2 {

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10)); // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc.change(5, 10); // Your container at index 5 will be filled with number 10.
        System.out.println(nc.find(10)); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is
        // filled with 10 is 1, we return 1.
        nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1
                          // was filled with 10 and then replaced with 20.
        System.out.println(nc.find(10)); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled
        // with 10 is 2. Therefore, we return 2.
    }

    static class NumberContainers {

        // Map to store number -> min heap of indices
        private Map<Integer, PriorityQueue<Integer>> numberToIndices;
        // Map to store index -> number
        private Map<Integer, Integer> indexToNumbers;

        public NumberContainers() {
            numberToIndices = new HashMap<>();
            indexToNumbers = new HashMap<>();
        }

        public void change(int index, int number) {
            // Update index to number mapping
            indexToNumbers.put(index, number);
            // Add index to the min heap for this number
            numberToIndices
                    .computeIfAbsent(number, k -> new PriorityQueue<>())
                    .add(index);
        }

        public int find(int number) {
            // If number doesn't exist in our map
            if (!numberToIndices.containsKey(number)) {
                return -1;
            }
            // Get min heap for this number
            PriorityQueue<Integer> minHeap = numberToIndices.get(number);
            // Keep checking top element until we find valid index
            while (!minHeap.isEmpty()) {
                int index = minHeap.peek();
                // If index still maps to our target number, return it
                if (indexToNumbers.get(index) == number) {
                    return index;
                }
                // Otherwise remove this stale index
                minHeap.poll();
            }
            return -1;
        }
    }
}
