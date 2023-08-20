//GFG
//Number of occurrence - Using Map
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class NumberOfOccurrence_2 {
    public static void main(String[] args) {
        int N = 7, X = 2;
        int Arr[] = { 1, 1, 2, 2, 2, 2, 3 };
        System.out.println(count(Arr, N, X));
    }

    static int count(int[] arr, int n, int x) {
        // code here
        HashMap<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++)
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        for (Map.Entry<Integer, Integer> z : mp.entrySet()) {
            if (z.getKey() == x)
                cnt = z.getValue();
        }
        return cnt;
    }
}
