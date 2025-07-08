//GFG
//Next element with greater frequency
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextElementWithGreaterFrequency {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 1, 3, 2, 1 };
        System.out.println(findGreater(arr));
    }

    public static ArrayList<Integer> findGreater(int[] arr) {
        // code here
        ArrayList<Integer> a = new ArrayList<>(Collections.nCopies(arr.length, -1));
        Map<Integer, Integer> m = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for (int i : arr) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && m.get(s.peek()) <= m.get(arr[i])) {
                s.pop();
            }

            if (!s.isEmpty())
                a.set(i, s.peek());

            s.push(arr[i]);
        }
        return a;
    }
}
