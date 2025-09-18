//GFG
//Next Greater Element in Circular Array
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementInCircularArray {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4 };
        System.out.println(nextGreater(arr));
    }

    public static ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        // Initialize result with -1
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        // Traverse the circular array twice
        for (int i = 0; i < 2 * n; i++) {
            int current = arr[i % n];
            while (!stack.isEmpty() && arr[stack.peek()] < current) {
                result.set(stack.pop(), current);
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}
