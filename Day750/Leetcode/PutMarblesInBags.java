//Leetcode
//2551. Put Marbles in Bags
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class PutMarblesInBags {

    public static void main(String[] args) {
        int[] weights = { 1, 3, 5, 1 };
        int k = 2;
        System.out.println(putMarbles(weights, k));
    }

    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == n)
            return 0;
        int[] W = new int[n - 1];
        for (int i = 1; i < n; i++)
            W[i - 1] = weights[i] + weights[i - 1];
        Arrays.sort(W);
        return max(W, k - 1) - min(W, k - 1);
    }

    public static long max(int[] W, int k) {
        int n = W.length;
        long res = 0;
        for (int i = n - 1; i >= n - k; i--)
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
