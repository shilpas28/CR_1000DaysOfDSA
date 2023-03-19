//GFG
//Distinct Difference
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctDifference_1 {

    public static void main(String[] args) {
        int N = 3;
        int arr[] = { 4, 3, 3 };
        System.out.println(getDistinctDifference(N, arr));
    }

    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        Map<Integer, Integer> x = new HashMap<>();
        Map<Integer, Integer> y = new HashMap<>();
        for (int i = 0; i < N; i++)
            y.put(A[i], y.getOrDefault(A[i], 0) + 1);

        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            // decrese count of curr ele from y
            y.put(A[i], y.get(A[i]) - 1);
            // if becomes 0 remove its existence
            if (y.get(A[i]) == 0)
                y.remove(A[i]);

            int curr_ans = x.size() - y.size();
            al.add(curr_ans);

            // place this curr_ele in left to help process for next tr
            x.put(A[i], x.getOrDefault(A[i], 0) + 1);
        }

        return al;
    }
}
