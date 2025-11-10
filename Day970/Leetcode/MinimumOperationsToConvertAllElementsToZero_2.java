//Leetcode
//3542. Minimum Operations to Convert All Elements to Zero
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class MinimumOperationsToConvertAllElementsToZero_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 1 };
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int a : nums) {
            while (!stack.isEmpty() && stack.peek() > a) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < a) {
                res++;
                stack.push(a);
            }
        }
        return res;
    }
}
