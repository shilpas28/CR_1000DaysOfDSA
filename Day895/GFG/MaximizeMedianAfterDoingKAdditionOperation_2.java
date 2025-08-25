//GFG
//Maximize median after doing k addition operation
//Time complexity: O(n * log k)
//Space complexity: O(1)

import java.util.Arrays;

public class MaximizeMedianAfterDoingKAdditionOperation_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5 };
        int k = 3;
        System.out.println(maximizeMedian(arr, k));
    }

    public static int maximizeMedian(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int md = (n - 1) / 2;
        long sm = k;
        int sz = 1, ans = k + arr[md];
        if (n % 2 == 0) {
            ans = (ans + arr[md + 1]) / 2;
            sm += arr[md++];
            sz++;
        }
        for (int i = md; i < n; i++) {
            sm += arr[i];
            int hf = (int) (sm / sz++);
            ans = Math.min(ans, hf);
        }
        return ans;
    }
}
