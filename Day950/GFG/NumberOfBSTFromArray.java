//GFG
//Number of BST From Array
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NumberOfBSTFromArray {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3 };
        System.out.println(countBSTs(arr));
    }

    public static ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        // Precompute Catalan numbers
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        // Map value -> count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - i - 1;
            map.put(sorted[i], dp[left] * dp[right]);
        }
        // Build answer in original order
        ArrayList<Integer> ans = new ArrayList<>();
        for (int val : arr) {
            ans.add(map.get(val));
        }

        return ans;
    }
}
