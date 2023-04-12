//GFG
//Dominant Pairs - 2nd Optimal solution (almost same as first but a bit better)
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class DominantPairs_2 {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 10, 2, 2, 1 };
        System.out.println(dominantPairs(n, arr));
    }

    public static int dominantPairs(int n, int[] arr) {
        // code here
        Arrays.sort(arr, 0, n / 2); // sort left half
        Arrays.sort(arr, n / 2, n); // sort right half

        int ans = 0;
        int j = n / 2;
        for (int i = 0; i < n / 2; i++) {
            while (j < n && arr[i] >= 5 * arr[j])
                j++;

            ans += j - n / 2;
        }
        return ans;
    }
}
