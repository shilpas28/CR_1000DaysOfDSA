//GFG
//Count Subarrays with given XOR
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class CountSubarraysWithGivenXOR {

    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 6, 4 };
        int k = 6;
        System.out.println(subarrayXor(arr, k));
    }

    public static long subarrayXor(int arr[], int k) {
        // code here
        int xor_ = 0, ans = 0;
        HashMap<Integer, Integer> mm = new HashMap<>();
        for (int x : arr) {
            xor_ ^= x;
            if (xor_ == k)
                ans++;
            ans += mm.getOrDefault(xor_ ^ k, 0);
            mm.put(xor_, mm.getOrDefault(xor_, 0) + 1);
        }
        return ans;
    }
}
