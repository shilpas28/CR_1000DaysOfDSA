//GFG
//Stock span problem
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args) {
        int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
        System.out.println(calculateSpan(arr));
    }

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        Stack<Integer> st = new Stack<>();
        Integer[] res = new Integer[arr.length];
        res[0] = 1;
        for (int i = 0; i < arr.length; ++i) {
            if (st.isEmpty()) {
                st.push(i);
            } else {
                while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                    st.pop();
                }

                if (st.isEmpty())
                    res[i] = i + 1;
                else
                    res[i] = i - st.peek();

                st.push(i);
            }
        }
        return new ArrayList<>(Arrays.asList(res));
    }
}
