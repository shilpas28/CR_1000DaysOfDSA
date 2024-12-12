//GFG
//Number of occurrence - Using Map
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class NumberOfOccurrence {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2, 2, 3 };
        int target = 2;
        System.out.println(countFreq(arr, target));
    }

    static int countFreq(int[] arr, int target) {
        // code here
        HashMap<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        for (Map.Entry<Integer, Integer> z : mp.entrySet()) {
            if (z.getKey() == target)
                cnt = z.getValue();
        }
        return cnt;
    }
}
