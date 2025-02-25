//GFG
//Histogram Max Rectangular Area - Optimised approach 2
//Time complexity: O(N) + O(N)
//Space complexity: O(N)

import java.util.Stack;

public class HistogramMaxRectangularArea_3 {

    public static void main(String[] args) {
        int arr[] = { 60, 20, 50, 40, 10, 50, 60 };
        System.out.println(getMaxArea(arr));
    }

    public static int getMaxArea(int arr[]) {
        // your code here
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || arr[st.peek()] >= arr[i])) {
                int height = arr[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
}
