//GFG
//Histogram Max Rectangular Area - Optimised Approach 1
//Time complexity: O(N)
//Space complexity: O(3N) where 3 is for the stack, left small array and a right small array

import java.util.Stack;

public class HistogramMaxRectangularArea_2 {

    public static void main(String[] args) {
        int arr[] = { 60, 20, 50, 40, 10, 50, 60 };
        System.out.println(getMaxArea(arr));
    }

    public static int getMaxArea(int arr[]) {
        // your code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                leftSmall[i] = 0;
            else
                leftSmall[i] = st.peek() + 1;
            st.push(i);
        }
        // clear the stack to be re-used
        while (!st.isEmpty())
            st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                rightSmall[i] = n - 1;
            else
                rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, arr[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }
}
