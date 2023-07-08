//Leetcode
//2551. Put Marbles in Bags - one pass solution 
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class PutMarblesInBags_3 {
    public static void main(String[] args) {
        int weights[] = {1,3,5,1};
        int k = 2;
        System.out.println(putMarbles(weights, k));
    }

    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == n) return 0;
        for (int i = 1; i < n; i++) weights[i-1] = weights[i] + weights[i-1];
        weights[n-1] = Integer.MAX_VALUE;
        Arrays.sort(weights);
        long res = 0L;
        for (int i = 0; i < k-1; i++)
            res += weights[n-2-i] - weights[i];
        return res;
    }
}
