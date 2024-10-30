//GFG
//Pairs with difference k
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.HashMap;
import java.util.Map;

public class PairsWithDifferenceK {

    public static void main(String[] args) {
        int arr[] = { 8, 12, 16, 4, 0, 20 };
        int k = 4;
        System.out.println(countPairsWithDiffK(arr, k));
    }

    static int countPairsWithDiffK(int[] arr, int k) {
        // code here
        int ans = 0;
        Map<Integer, Integer> mm = new HashMap<>();
        for (int x : arr)
            mm.put(x, mm.getOrDefault(x, 0) + 1);
        for (int x : arr)
            ans += mm.getOrDefault(x + k, 0);
        return ans;
    }
}
