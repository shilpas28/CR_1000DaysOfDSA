//Leetcode
//1441. Build an Array With Stack Operations - Optimized Approach Using Two Pointers
//Time complexity: O(n) - The code iterates through the target array, which has a length of n, exactly once. For each 
//element in the target array, it performs a constant number of operations (push and/or pop). Therefore, the time complexity 
//of this code is O(n), where n is the length of the target array.
//Space complexity: O(n) - The space complexity of this code is determined by the space used for the operations list. The 
//size of the operations list can be at most 2n, where n is the length of the target array. This is because, in the worst 
//case, for each element in the target array, you might have to push and pop, resulting in two operations. Therefore, the 
//space complexity is O(n), where n is the length of the target array.

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations_2 {

    public static void main(String[] args) {
        int[] target = { 1, 3 };
        int n = 3;
        System.out.println(buildArray(target, n));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int targetIndex = 0; // Pointer for target array
        int currentNumber = 1; // Pointer for numbers 1 to n

        while (targetIndex < target.length) {
            if (target[targetIndex] == currentNumber) {
                // If the current number in the target array matches the current number 1 to n
                // Push "Push" operation and move both pointers
                operations.add("Push");
                targetIndex++;
            } else {
                // If the numbers don't match, push "Push" followed by "Pop" operation
                // and only move the current number pointer
                operations.add("Push");
                operations.add("Pop");
            }
            currentNumber++;
        }
        return operations;
    }
}
