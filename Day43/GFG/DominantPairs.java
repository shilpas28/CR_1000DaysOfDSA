//GFG
//Dominant Pairs - 1st Optimal solution 
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class DominantPairs {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 10, 2, 2, 1 };
        System.out.println(dominantPairs(n, arr));
    }

    public static int dominantPairs(int n, int[] arr) {
        // code here
        Arrays.sort(arr, 0, n / 2);
        Arrays.sort(arr, n / 2, n);

        int i = 0, j = n / 2;
        int ans = 0;

        while (i < n / 2 && j < n) {
            if (arr[i] >= 5 * arr[j]) {
                ans += (n / 2 - i);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }
}
