//Leetcode
//1441. Build an Array With Stack Operations - Efficient Method=> Stack
//Time complexity: O(n) - The code uses a single loop that iterates from 1 to n. For each iteration of the loop, it performs 
//some constant-time operations (e.g., comparisons and list additions). Therefore, the time complexity of the code is O(n), 
//where 'n' is the value of the parameter n.
//Space complexity: O(n) - The space complexity of the code primarily depends on the space used for the operations list. In 
//the worst case, when every element from 1 to n needs to be pushed onto the stack and then popped, the operations list will 
//contain 2 * n elements. As a result, the space complexity is O(n) because it grows linearly with the input size n.

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations_3 {

    public static void main(String[] args) {
        int[] target = { 1, 3 };
        int n = 3;
        System.out.println(buildArray(target, n));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int currentIndex = 0;

        for (int i = 1; i <= n; i++) {
            if (currentIndex >= target.length) {
                // We've processed all elements in the target array
                break;
            }
            if (target[currentIndex] == i) {
                // Current element matches the target
                operations.add("Push");
                currentIndex++;
            } else {
                // Current element does not match the target
                operations.add("Push");
                operations.add("Pop");
            }
        }
        return operations;
    }
}
