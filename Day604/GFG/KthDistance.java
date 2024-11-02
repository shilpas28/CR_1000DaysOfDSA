//GFG
//Kth distance
//Time complexity: O(N)
//Space complexity: O(k)

import java.util.HashMap;
import java.util.Map;

public class KthDistance {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 1, 2, 3, 4 };
        int k = 3;
        System.out.println(checkDuplicatesWithinK(arr, k));
    }

    public static boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; --i) {
            if (map.containsKey(arr[i])) {
                int x = map.get(arr[i]);
                if (x - i <= k)
                    return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }
}
