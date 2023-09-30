//Leetcode 
//456. 132 Pattern - Optimal method
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Stack;

public class OneThreeTwoPattern_3 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int thirdElement = Integer.MIN_VALUE; // nums[k]
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < thirdElement)
                return true;
            while (!st.empty() && st.peek() < nums[i]) {
                thirdElement = st.peek();
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}
