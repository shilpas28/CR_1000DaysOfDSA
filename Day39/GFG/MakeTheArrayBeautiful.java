//GFG
//Make the Array Beautiful
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Stack;

public class MakeTheArrayBeautiful {

    public static void main(String[] args) {
        int[] arr = { 4, 2, -2, 1 };
        System.out.println(makeBeautiful(arr));
    }

    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (i < arr.length) {
            if (!st.isEmpty() && ((arr[i] < 0 && st.peek() >= 0) || (arr[i] >= 0 && st.peek() < 0)))
                st.pop();
            else
                st.add(arr[i]);
            i++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty())
            ans.add(0, st.pop());

        return ans;
    }
}
