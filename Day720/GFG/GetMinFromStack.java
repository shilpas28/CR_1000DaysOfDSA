//GFG
//Get Min from Stack
//Time complexity: O(1)
//Space complexity: O(1)

import java.util.Scanner;
import java.util.Stack;

public class GetMinFromStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            GetMinFromStack g = new GetMinFromStack();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }

    int min;
    Stack<Integer> st = new Stack<>();

    public GetMinFromStack() {
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        if (st.isEmpty()) {
            min = x;
        } else if (x <= min) {
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if (st.isEmpty())
            return;
        int tmp = st.pop();
        if (tmp == min) {
            if (!st.isEmpty()) {
                min = st.pop();
            }
        }
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        if (st.isEmpty())
            return -1;
        return st.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        if (st.isEmpty())
            return -1;
        return min;
    }
}
