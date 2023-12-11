//GFG
//Max Sum Subarray of size K - Brute force Method - Not accepted as TLE
//Time complexity: O(N*K)
//Space compexity: O(1)

package GFG;

import java.util.ArrayList;

public class MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int N = 4, K = 2;
        ArrayList<Integer> Arr = new ArrayList<>();
        Arr.add(100);
        Arr.add(200);
        Arr.add(300);
        Arr.add(400);
        System.out.println(maximumSumSubarray(K, Arr, N));
    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        // code here
        int ans = -1;

        for (int i = 0; i < N - K + 1; i++) {
            int s = 0;
            for (int j = 0; j < K; j++) {
                s += Arr.get(i + j);
            }
            ans = Math.max(ans, s);
        }

        return ans;
    }
}
