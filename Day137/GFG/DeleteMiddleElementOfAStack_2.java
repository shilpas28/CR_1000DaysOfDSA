//GFG
//Delete middle element of a stack - Using Recursion
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class DeleteMiddleElementOfAStack_2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);
        stack.add(50);
        int n = stack.size();
        deleteMid(stack, n);
    }

    // Function to delete middle element of a stack.
    public static void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        helper(s, sizeOfStack, 0);
    }

    static void helper(Stack<Integer> s, int n, int idx) {
        if (idx == n / 2) {
            s.pop();
            return;
        }
        // store the ele
        int x = s.pop();
        idx++;
        helper(s, n, idx);
        s.push(x);
    }
}
