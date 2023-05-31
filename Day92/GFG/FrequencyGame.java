//GFG
//Frequency Game
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class FrequencyGame {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 2, 2, 5, 50, 1 };
        System.out.println(LargButMinFreq(arr, n));
    }

    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int min_val = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int x = e.getKey();
            int y = e.getValue();
            if (y <= min_val) {
                ans = Math.max(ans, x);
                min_val = y;
            }
        }
        return ans;
    }
}
