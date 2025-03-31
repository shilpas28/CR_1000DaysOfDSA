//Leetcode
//2551. Put Marbles in Bags
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class PutMarblesInBags_2 {

    public static void main(String[] args) {
        int[] weights = { 1, 3, 5, 1 };
        int k = 2;
        System.out.println(putMarbles(weights, k));
    }

    public static long putMarbles(int[] weights, int k) {

        int n = weights.length;
        if (k == n)
            return 0;
        for (int i = 1; i < n; i++)
            weights[i - 1] = weights[i] + weights[i - 1];
        weights[n - 1] = Integer.MAX_VALUE;
        Arrays.sort(weights);
        return max(weights, k - 1) - min(weights, k - 1);
    }

    public static long max(int[] W, int k) {
        int n = W.length;
        long res = 0;
        for (int i = n - 2; i >= n - k - 1; i--)
            res += W[i];
        return res;
    }

    public static long min(int[] W, int k) {
        long res = 0;
        for (int i = 0; i < k; i++)
            res += W[i];
        return res;
    }
}
