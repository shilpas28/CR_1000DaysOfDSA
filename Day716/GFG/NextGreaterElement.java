//GFG
//Next Greater Element
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4 };
        System.out.println(nextLargerElement(arr));
    }

    // Function to find the next greater element for each element of the array.
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(arr.length, -1));
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans.set(st.pop(), arr[i]);
            }
            st.push(i);
        }
        return ans;
    }
}
