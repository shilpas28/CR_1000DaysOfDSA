//GFG
//Subarrays with sum K
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class SubarraysWithSumK {

    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        System.out.println(countSubarrays(arr, k));
    }

    public static int countSubarrays(int arr[], int k) {
        // code here
        int sum = 0, ans = 0;
        HashMap<Integer, Integer> mm = new HashMap<>();
        for (int x : arr) {
            sum += x;
            if (sum == k)
                ans++;
            ans += mm.getOrDefault(sum - k, 0);
            mm.put(sum, mm.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
