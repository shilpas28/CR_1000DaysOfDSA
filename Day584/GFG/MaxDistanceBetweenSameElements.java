//GFG
//Max distance between same elements
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class MaxDistanceBetweenSameElements {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2 };
        System.out.println(maxDistance(arr));
    }

    public static int maxDistance(int[] arr) {
        // Code here
        int n = arr.length;
        int ans = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mpp.containsKey(arr[i]))
                ans = Math.max(ans, i - mpp.get(arr[i]));
            else
                mpp.put(arr[i], i);
        }
        return ans;
    }
}
