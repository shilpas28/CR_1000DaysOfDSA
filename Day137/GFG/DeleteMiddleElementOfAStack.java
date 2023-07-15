//GFG
//Delete middle element of a stack - Using Auxiliary Stack
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayDeque;
import java.util.Stack;

public class DeleteMiddleElementOfAStack {

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
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int m = sizeOfStack / 2;
        int i = 0;
        while (!s.isEmpty()) {
            st.push(s.pop());
            i++;

            if (i == m)
                s.pop();
        }
        while (!st.isEmpty())
            s.push(st.pop());
    }
}
