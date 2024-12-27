//GFG
//Count pairs with given sum
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.HashMap;

public class CountPairsWithGivenSum {

    public static void main(String[] args) {
        int arr[] = { 1, 5, 7, -1, 5 };
        int target = 6;
        System.out.println(countPairs(arr, target));
    }

    static int countPairs(int arr[], int target) {
        // Your code here
        int ans = 0;
        HashMap<Integer, Integer> mm = new HashMap<>();
        for (int x : arr) {
            if (mm.get(target - x) != null)
                ans += mm.get(target - x);
            mm.put(x, mm.getOrDefault(x, 0) + 1);
        }
        return ans;
    }
}
