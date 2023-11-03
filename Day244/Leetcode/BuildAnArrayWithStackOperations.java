//Leetcode
//1441. Build an Array With Stack Operations - Brute force method
//Time complexity: O(n) - The time complexity of the code is O(n), where 'n' is the value of the parameter n. This is 
//because the code iterates through the numbers from 1 to n once, and for each number, it performs constant-time operations
// to push and pop elements or add elements to the result list. The key loop is based on the length of the target array, 
//which can be at most 'n' in size. Therefore, the overall time complexity is linear in terms of 'n'.
//Space complexity: O(n) - The space complexity of the code is O(n), where 'n' is the size of the target array. The space 
//complexity is determined by the size of the result list, which stores the operations. In the worst case, the result list 
//may contain one operation per element in the target array.

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

    public static void main(String[] args) {
        int[] target = { 1, 3 };
        int n = 3;
        System.out.println(buildArray(target, n));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int current = 1; // The current number to be pushed.

        for (int i = 0; i < target.length; i++) {
            while (current < target[i]) {
                // While the current number is less than the target number,
                // push the current number and generate the "Push" operation.
                result.add("Push");
                result.add("Pop"); // After pushing, immediately pop.
                current++;
            }
            // The current number matches the target number, so push it.
            result.add("Push");
            current++; // Move to the next number to be pushed.
        }
        return result;
    }
}
