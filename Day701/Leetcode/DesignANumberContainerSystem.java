//Leetcode
//2349. Design a Number Container System - Two Maps
//Time complexity: O(logN)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignANumberContainerSystem {

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

        // Maps from number to set of indices and from index to number
        private Map<Integer, TreeSet<Integer>> numberToIndices;
        private Map<Integer, Integer> indexToNumbers;

        // Constructor
        public NumberContainers() {
            // Initialize the data structures
            numberToIndices = new HashMap<>();
            indexToNumbers = new HashMap<>();
        }

        public void change(int index, int number) {
            // If index already has a number, remove it from the old number's index set
            if (indexToNumbers.containsKey(index)) {
                int previousNumber = indexToNumbers.get(index);
                numberToIndices.get(previousNumber).remove(index);
                if (numberToIndices.get(previousNumber).isEmpty()) {
                    numberToIndices.remove(previousNumber);
                }
            }
            // Update the number and add the index to the new number's set
            indexToNumbers.put(index, number);
            numberToIndices.putIfAbsent(number, new TreeSet<>());
            numberToIndices.get(number).add(index);
        }

        public int find(int number) {
            // Return the smallest index for the given number, or -1 if not found
            if (numberToIndices.containsKey(number)) {
                return numberToIndices.get(number).first(); // Get the smallest index
            }
            return -1;
        }
    }
}
